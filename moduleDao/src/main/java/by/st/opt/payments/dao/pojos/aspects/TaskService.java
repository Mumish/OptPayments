/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.opt.payments.dao.pojos.aspects;

import org.springframework.stereotype.Component;

/**
 *
 * @author Mumish
 */
@Component
public class TaskService {

    public void performJob() {
        System.out.println("perform unnamed job");
    }

    public void performJob(String name) {
        System.out.println("perform job: " + name);
    }

}
