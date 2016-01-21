/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.optpaymentsdao.db;

import by.st.optpaymentsdao.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mumish
 */
public class BaseDao<T> {

    public T get(long id, Class<T> clazz) throws Exception {

        Session session = null;
        T t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = (T) session.get(clazz.getCanonicalName(), id);
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return t;
    }

    public T saveOrUpdate(T t) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            session.saveOrUpdate(t);
            session.update(t);
            transaction.commit();
        } catch (HibernateException e) {
            //log.error
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return t;
    }
}
