package by.st.opt.payments.dao.db;

import by.st.opt.payments.dao.main.Main;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDao<T> implements Dao<T> {

    private static Logger log = Logger.getLogger(BaseDao.class);
    private Transaction transaction = null;
    private Class<T> type;

    public BaseDao(Class<T> type) {
        //т.к. не работает рефлекисия, приходится так
//        (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.type = type;
    }

    @Override
    public void saveOrUpdate(T t) throws Exception {
        try {
            Session session = Main.getUtil().getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update " + this.type + " in Dao" + e);
            transaction.rollback();
            throw e;
        }

    }

    public T get(Serializable id) throws Exception {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            Session session = Main.getUtil().getSession();
            transaction = session.beginTransaction();
            t = (T) session.get(this.type, id);
            transaction.commit();
            log.info("get clazz:" + t);
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error get " + this.type + " in Dao" + e);
            throw e;
        }
        return t;
    }

    public T load(Serializable id) throws Exception {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            Session session = Main.getUtil().getSession();
            transaction = session.beginTransaction();
            t = (T) session.load(this.type, id);
//            log.info("load() clazz:" + t);
//            session.isDirty();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + this.type + " in Dao" + e);
            transaction.rollback();
            throw e;
        }
        return t;
    }

    public void delete(T t) throws Exception {
        try {
            Session session = Main.getUtil().getSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error save or update  " + this.type + "  in Dao" + e);
            transaction.rollback();
            throw e;
        }
    }

    //эта штука не во всех хибернет поддерживается
//    private Class getPersistentClass() {
//        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
