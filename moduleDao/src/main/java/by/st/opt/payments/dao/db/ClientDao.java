/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.st.opt.payments.dao.db;

import by.st.opt.payments.dao.main.Main;
import by.st.opt.payments.dao.pojos.Client;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClientDao extends BaseDao<Client> {

    private static Logger log = Logger.getLogger(Client.class);

    public void flush(long id, String newName) throws Exception {
        try {
            Session session = Main.getUtil().getSession();
            Client p = (Client) session.get(Client.class, id);
            System.out.println(p);
            p.setFio(newName);
            System.out.println(p);
            session.flush();
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Flush Client" + e);
            throw e;
        }

    }

}
