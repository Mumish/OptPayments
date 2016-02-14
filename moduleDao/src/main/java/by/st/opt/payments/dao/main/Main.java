/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.opt.payments.dao.main;

import by.st.opt.payments.dao.db.BaseDao;
import by.st.opt.payments.dao.db.Dao;
import by.st.opt.payments.dao.pojos.Account;
import by.st.opt.payments.dao.pojos.Client;
import by.st.opt.payments.dao.pojos.CreditCard;
import by.st.opt.payments.dao.pojos.PayOrder;
import by.st.opt.payments.dao.pojos.Payment;
import by.st.opt.payments.dao.pojos.Person;
import by.st.opt.payments.dao.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Mumish
 */
//@Controller
//@Scope("prototype")
public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    private static HibernateUtil util = null;

    public static HibernateUtil getUtil() throws Exception {
        if (util == null) {
            util = HibernateUtil.getHibernateUtil();
        }
        return util;
    }

    public static void helpMethodSpting(String className, String funcName) {
        System.out.println(className + " " + funcName + " method");

    }

    public static void main(String[] args) throws Exception {
        testSpring();

//        try {
//
//           
//            
//            mFillBase();
//
//            doHql();
//
//            //TODO:Реверс зависимостей имеет смысл только в one-many?
//            //ибо в one-one не увидел разницы по sql
//            ////////////////////
//            ClientDao dao = new ClientDao();
//            dao.flush(1, "sdsd");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            util.destroy();
//        }
//        BaseDao<Employee> dao = new BaseDao();
//
////       Employee t= dao.get(7L, Employee.class);
////       
////        System.out.println(t.toString());
//        Employee t = new Employee();
////        t.setId(7);
//        t.setFirstName("client fio2");
//        t.setLastName("client login2");
//        dao.saveOrUpdate(t);
//        HibernateUtil.getSessionFactory().close();
    }

    private static void testSpring() throws BeansException {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("springConfig.xml");
        System.out.println("context configured(Singletones inited)...");
        
        Person person = (Person) context.getBean("person");
        System.out.println("use AppContext name: " + person.getName());
        System.out.println("use AppContext age: " + person.getAge());
        System.out.println("use AppContext addr: " + person.getAddress().getAddress());

        Person person2 = (Person) context.getBean("person");
        System.out.println("use AppContext name: " + person2.getName());
        System.out.println("use AppContext age: " + person.getAge());
        System.out.println("use AppContext addr: " + person2.getAddress().getAddress());

        System.out.println("------test scope---");
        person2.getAddress().setAddress("new addr for singleton");
        person2.setName("new name for prototype");
        System.out.println("use AppContext name: " + person.getName());
        System.out.println("use AppContext addr: " + person.getAddress().getAddress());
        System.out.println("use AppContext name: " + person2.getName());
        System.out.println("use AppContext addr: " + person2.getAddress().getAddress());
    }

    /**
     * Наполняет базу данными предметной области
     *
     * @throws Exception
     */
    private static void mFillBase() throws Exception {
        //        new ClientDao().flush(7L, "new Name");
/////
//        session.getTransaction().commit();
//        session.close();
///////////////////
        Dao<Client> daoClient = new BaseDao<>(Client.class);
        Client t = new Client();
        t.setFio("client fio2");
        t.setLogin("client login2");
        t.setPassword("client password");

//            daoClient.saveOrUpdate(t);
//////////////////
//            Dao<Account> daoAccount = new BaseDao<>(Account.class);
        Account a = new Account();
        a.setNum("ACC-" + t.getClientId());
        a.setBalance(0);
        a.setDateOpen(new Date());
        a.setStatusId(2);
//            daoAccount.saveOrUpdate(a);
//////////////////
//            Dao<CreditCard> daoCard = new BaseDao<>(CreditCard.class);
//            Dao<CreditCard> daoCard = new BaseDao<>(CreditCard.class);
        CreditCard c = new CreditCard();
        c.setNum("CC-" + t.getClientId());
        c.setBalance(1000);
        c.setDateOpen(new Date());
        c.setStatusId(1);
//            daoCard.saveOrUpdate(c);

//////////////////
//            Dao<Order> daoOrder = new BaseDao<>(Order.class);
        PayOrder o1 = new PayOrder();
        o1.setNum("ORD-1" + t.getClientId());
        o1.setPrice(100);
        o1.setDateOpen(new Date());
        o1.setStatusId(1);
//            daoOrder.saveOrUpdate(o);
//            Dao<Order> daoOrder = new BaseDao<>(Order.class);
        PayOrder o2 = new PayOrder();
        o2.setNum("ORD-2" + t.getClientId());
        o2.setPrice(250);
        o2.setDateOpen(new Date());
        o2.setStatusId(1);
//            daoOrder.saveOrUpdate(o);

        t.setAccount(a);
        a.setClient(t);
//
        t.setCreditCard(c);
        c.setClient(t);
//
        o1.setClient(t);
        o2.setClient(t);
        List<PayOrder> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);

        for (int i = 1; i < 5; i++) {
            PayOrder o = new PayOrder();
            o.setNum("ORD-i" + i + t.getClientId());
            o.setPrice(100 * i);
            o.setDateOpen(new Date());
            o.setStatusId(1);
            o.setClient(t);
            orders.add(o);
        }

        t.setOrders(orders);
        daoClient.saveOrUpdate(t);
//daoClient.delete(t);
//////////////////
        Dao<Payment> daoPayment = new BaseDao<>(Payment.class);
        Payment p = new Payment();
        p.setAmount(500);
        p.setDatePayment(new Date());

//
        o2.setPayment(p);
        o2.setStatusId(3);
        p.setOrder(o2);
//            daoOrder.saveOrUpdate(o2);
        daoPayment.saveOrUpdate(p);
    }

    public void register(Client client) throws Exception {

        Dao<Client> daoClient = new BaseDao<>(Client.class);
        daoClient.saveOrUpdate(client);

    }

    public Client login(String login, String password) throws Exception {

        //TODO: здесь метод find по логину и паролю 
        return new Client();
    }

    public void pay(Client client, long orderId) throws Exception {

        //TODO: здесь либо хранимка либо бизнес логика платежа 
    }

    public void lockCard(Client client) throws Exception {

        //TODO: Обновляем статус своей карты, если она в подходящем
    }

    public void unlockCard(Client client) throws Exception {

        //TODO: Обновляем статус своей карты, если она в подходящем
    }

    public void lockAccount(Client client) throws Exception {

        //TODO: Обновляем статус счета, если он в подходящем статусе
    }

    /////Админ
    public void lockCardByCredit(CreditCard card) throws Exception {

        //TODO: Обновляем статус карты клиента, если у нее задолженность
    }

    public void createOrder(PayOrder order) {

        //TODO: Создает заказ на указунную сумму и клиента
    }

    /**
     * Тест hql запросов
     */
    private static void doHql() throws Exception {
        String hql = "FROM Client";
        System.out.println("do hql-query: " + hql);
        Query query = getUtil().getSession().createQuery(hql);
        List<Client> clients = query.list();
        System.out.println("query result (size=" + clients.size() + ") first: " + clients.get(0));
        /////////////
        hql = "SELECT c.account FROM Client c WHERE c.clientId=:clientId";
        System.out.println("do hql-query: " + hql);
        query = getUtil().getSession().createQuery(hql);
        query.setParameter("clientId", clients.get(0).getClientId());
        List<Account> accounts = query.list();
        System.out.println("query result (size=" + accounts.size() + ") first: " + accounts.get(0));
        //////
        mPagination(clients.get(0).getClientId());
//        /////criteria
//
//        Criteria criteria = getUtil().getSession().createCriteria(PayOrder.class);
//        criteria.add(Restrictions.eq("client", clients.get(0)));
//        System.out.println("do Criteria^ " + criteria);
//        List<PayOrder> orders = criteria.list();
//        System.out.println("query result (size=" + orders.size() + ") first: " + orders.get(0));
    }

    private static void mPagination(long clientId) throws Exception {
        String hql;
        Query query;
        /////////////
        hql = "SELECT c.orders FROM Client c WHERE c.clientId=:clientId";
        System.out.println("do hql-query: " + hql);
        query = getUtil().getSession().createQuery(hql);
        //TODO: как узнать, что кэш работает?
        query.setParameter("clientId", clientId);
        query.setCacheable(true);
        System.out.println("11111");
        List<PayOrder> orders = query.list();
        System.out.println("query result (size=" + orders.size() + ") first: " + orders.get(0));
        query = getUtil().getSession().createQuery(hql);
        query.setParameter("clientId", clientId);
//        query.setCacheable(true);
        System.out.println("2222");
        orders = query.list();
        System.out.println("query result (size=" + orders.size() + ") first: " + orders.get(0));
        /////////////
        int startPos = 0;
        int maxRes = 3;
        System.out.println("Paging (startPos=" + startPos + ", maxRes=" + maxRes + "): ");
        query.setFirstResult(startPos);
        query.setMaxResults(maxRes);
        query.setCacheable(true);
        orders = query.list();
        System.out.println("query result (size=" + orders.size() + "):");
        for (PayOrder order : orders) {
            System.out.println(order);
        }
        /////////////
        startPos = startPos + maxRes;
        maxRes = 3;
        System.out.println("Paging (startPos=" + startPos + ", maxRes=" + maxRes + "): ");
        query.setFirstResult(startPos);
        query.setMaxResults(maxRes);
        orders = query.list();
        System.out.println("query result (size=" + orders.size() + "):");
        for (PayOrder order : orders) {
            System.out.println(order);
        }
    }
}
