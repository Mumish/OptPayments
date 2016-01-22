/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.optpaymentsdao.db;

import by.st.optpaymentsdao.pojos.Client;
import by.st.optpaymentsdao.pojos.Employee;
import by.st.optpaymentsdao.util.HibernateUtil;

/**
 *
 * @author Mumish
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BaseDao<Employee> dao = new BaseDao();
        Employee t = new Employee();
        t.setFirstName("client fio1");
        t.setLastName("client login");
        dao.saveOrUpdate(t);
        HibernateUtil.getSessionFactory().close();
    }
}
