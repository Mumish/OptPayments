/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.optpaymentsdao.db;

import by.st.opt.payments.dao.db.ClientDao;
import junit.framework.TestCase;

/**
 *
 * @author Mumish
 */
public class ClientDaoIT extends TestCase {
    
    public ClientDaoIT(String testName) {
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
     * Test of flush method, of class ClientDao.
     */
    public void testFlush() throws Exception {
        System.out.println("flush");
        long id = 0L;
        String newName = "";
        ClientDao instance = new ClientDao();
        instance.flush(id, newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
