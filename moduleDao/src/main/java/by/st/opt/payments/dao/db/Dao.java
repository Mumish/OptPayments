package by.st.opt.payments.dao.db;

import java.io.Serializable;

public interface Dao<T> {

    void saveOrUpdate(T t) throws Exception;

    T get(Serializable id) throws Exception;

    T load(Serializable id) throws Exception;

    void delete(T t) throws Exception;
}
