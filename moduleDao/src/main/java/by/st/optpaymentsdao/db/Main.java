/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.optpaymentsdao.db;

import by.st.optpaymentsdao.pojos.Client;
import by.st.optpaymentsdao.pojos.Employee;

/**
 *
 * @author Mumish
 */
public class Main {

    public static void main(String[] args) throws Exception {

        BaseDao<Employee> dao = new BaseDao();
        Employee t = new Employee();
        t.setFirstName("client fio");
        t.setLastName("client login");
        dao.saveOrUpdate(t);
//        
//////        logger.info("Trying to create a test connection with the database.");
////        System.out.println("ня");
////        Configuration configuration = new Configuration();
////        configuration.configure("hibernate.cfg.xml");
////        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
////        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
////        Session session = sessionFactory.openSession();
//////        logger.info("Test connection with the database created successfuly.");
////        System.out.println("ня");
////        logger.info("Trying to create a test connection with the database.");
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
////        logger.info("Test connection with the database created successfuly.");
//        System.out.println("ня");
    }
}
