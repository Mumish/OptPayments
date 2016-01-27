/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.opt.payments.dao.db;

import by.st.opt.payments.dao.pojos.Client;
import java.io.Serializable;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Mumish
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseDaoTest {

    private static Logger log = Logger.getLogger(BaseDaoTest.class);

    static long insertedId;
    static Object inserted;
    static BaseDao<Client> baseDao;

    static {
        baseDao = new BaseDao<>(Client.class);

        Client t = new Client();
        t.setId(1L);
        t.setFio("test fio");
        t.setLogin("test login");
        t.setPassword("test password");
        inserted = t;
        insertedId = t.getId();
    }

    public BaseDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveOrUpdate method, of class BaseDao.
     */
    @Test
    public void atestSaveOrUpdate() throws Exception {
        log.info("saveOrUpdate");

        Client forInsert = (Client) inserted;
        forInsert.setId(0); //используется generatedId
        baseDao.saveOrUpdate(forInsert);
        log.info("inserting " + inserted);

        Object getted = baseDao.load(insertedId);
        assertEquals(inserted, getted);
    }

    /**
     * Test of get method, of class BaseDao.
     */
    @Test
    public void testGet() throws Exception {
        log.info("get");
        Object getted = baseDao.get(insertedId);
        assertEquals(inserted, getted);
    }

    /**
     * Test of load method, of class BaseDao.
     */
    @Test
    public void testLoad() throws Exception {
        log.info("load");
        Object loaded = baseDao.load(insertedId);
        assertEquals(inserted, loaded);
    }

    /**
     * Test of delete method, of class BaseDao.
     */
    @Test
    public void ztestDelete() throws Exception {
        log.info("delete");

        baseDao.delete((Client) inserted);
        Object getted = baseDao.get(insertedId);
        assertEquals(null, getted);
    }

    /**
     * Test of getTransaction method, of class BaseDao.
     */
    @Test
    public void testGetTransaction() {
        log.info("getTransaction");

        Transaction expResult = null;
        Transaction result = baseDao.getTransaction();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of setTransaction method, of class BaseDao.
     */
    @Test
    public void testSetTransaction() {
        log.info("setTransaction");
        Transaction expected = baseDao.getTransaction();

        baseDao.setTransaction(null);
        Transaction result = baseDao.getTransaction();
        assertEquals(null, result);

        baseDao.setTransaction(expected);
        result = baseDao.getTransaction();
        assertEquals(expected, result);
    }

}
