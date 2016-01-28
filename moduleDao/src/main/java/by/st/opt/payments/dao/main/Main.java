/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.opt.payments.dao.main;

import by.st.opt.payments.dao.db.BaseDao;
import by.st.opt.payments.dao.db.ClientDao;
import by.st.opt.payments.dao.db.Dao;
import by.st.opt.payments.dao.pojos.Account;
import by.st.opt.payments.dao.pojos.Client;
import by.st.opt.payments.dao.pojos.CreditCard;
import by.st.opt.payments.dao.pojos.Empl;
import by.st.opt.payments.dao.pojos.Order;
import by.st.opt.payments.dao.pojos.Payment;
import by.st.opt.payments.dao.util.HibernateUtil;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 *
 * @author Mumish
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    private static HibernateUtil util = null;

    public static HibernateUtil getUtil() throws Exception {
        if (util == null) {
            util = HibernateUtil.getHibernateUtil();
        }
        return util;
    }

    public static void main(String[] args) throws Exception {
        try {

//        new ClientDao().flush(7L, "new Name");
/////
            Dao<Client> daoClient = new BaseDao<>(Client.class);
            Client t = new Client();
            t.setFio("client fio2");
            t.setLogin("client login2");
            t.setPassword("client password");
//            Empl emp = new Empl();
//            emp.setLog("log");
//            emp.setPass("pass");
//            t.getEmployees().add(emp);

            daoClient.saveOrUpdate(t);
            //////////////////
            Dao<Empl> daoEmpl = new BaseDao<>(Empl.class);
            Empl e = new Empl();
            e.setLog("log");
            e.setPass("pass");
            t.setId(1L);
            e.setClient(t);
            daoEmpl.saveOrUpdate(e);
            //////////////////
            Dao<Account> daoAccount = new BaseDao<>(Account.class);
            Account a = new Account();
            a.setClientId(t.getId());
            a.setNum("ACC-" + a.getClientId());
            a.setBalance(0);
            a.setDateOpen(new Date());
            a.setStatusId(1);
            daoAccount.saveOrUpdate(a);
            //////////////////
            Dao<CreditCard> daoCard = new BaseDao<>(CreditCard.class);
            CreditCard c = new CreditCard();
            c.setClientId(t.getId());
            c.setNum("CC-" + c.getClientId());
            c.setBalance(1000);
            c.setDateOpen(new Date());
            c.setStatusId(1);
            daoCard.saveOrUpdate(c);
            //////////////////
            Dao<Order> daoOrder = new BaseDao<>(Order.class);
            Order o = new Order();
            o.setClientId(t.getId());
            o.setNum("ORD-" + o.getClientId());
            o.setPrice(500);
            o.setDateOpen(new Date());
            o.setStatusId(1);
            daoOrder.saveOrUpdate(o);
            //////////////////
            Dao<Payment> daoPayment = new BaseDao<>(Payment.class);
            Payment p = new Payment();
            p.setClientId(t.getId());
            p.setAccountId(1);
            p.setAmount(500);
            //or OrderId or AccountId with Amount
//            p.setOrderId(1);

            p.setDatePayment(new Date());

            daoPayment.saveOrUpdate(p);

            ClientDao dao = new ClientDao();
            dao.flush(1, "sdsd");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            util.destroy();
        }

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

    public void createOrder(Order order) {

        //TODO: Создает заказ на указунную сумму и клиента
    }
}
