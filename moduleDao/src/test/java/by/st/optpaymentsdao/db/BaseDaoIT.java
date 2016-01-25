/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.optpaymentsdao.db;

import by.st.opt.payments.dao.db.BaseDao;
import by.st.opt.payments.dao.db.ClientDao;
import by.st.opt.payments.dao.pojos.Client;
import java.io.Serializable;
import junit.framework.TestCase;
import org.hibernate.Transaction;

/**
 *
 * @author Mumish
 */
public class BaseDaoIT extends TestCase {

    public BaseDaoIT(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of saveOrUpdate method, of class BaseDao.
     */
    public void testSaveOrUpdate() throws Exception {
        System.out.println("saveOrUpdate");
        Client t = new Client();
        t.setId(1);
        t.setFio("test fio");
        t.setLogin("test login");
        BaseDao instance = new ClientDao();
        instance.saveOrUpdate(t);
        assertTrue("inserting " + t, true);
    }

    /**
     * Test of get method, of class BaseDao.
     */
    public void testGet() throws Exception {
        Serializable id = 1L;
        System.out.println("get id =" + id);

        BaseDao instance = new ClientDao();
        Client expResult = new Client();
        expResult.setId(1);
        expResult.setFio("test fio");
        expResult.setLogin("test login");
        Client result = (Client) instance.get(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of load method, of class BaseDao.
     */
    public void testLoad() throws Exception {
        System.out.println("load");
        Serializable id = null;
        BaseDao instance = new BaseDao();
        Object expResult = null;
        Object result = instance.load(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BaseDao.
     */
    public void testDelete() throws Exception {
        System.out.println("delete");
        Object t = null;
        BaseDao instance = new BaseDao();
        instance.delete(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransaction method, of class BaseDao.
     */
    public void testGetTransaction() {
        System.out.println("getTransaction");
        BaseDao instance = new BaseDao();
        Transaction expResult = null;
        Transaction result = instance.getTransaction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransaction method, of class BaseDao.
     */
    public void testSetTransaction() {
        System.out.println("setTransaction");
        Transaction transaction = null;
        BaseDao instance = new BaseDao();
        instance.setTransaction(transaction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
