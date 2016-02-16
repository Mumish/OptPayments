/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.st.opt.payments.dao.pojos.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Mumish
 */
@Aspect
public class Work {

//    private static Logger logger = Logger.getLogger(Work.class);
    @Pointcut("execution(* by.st.opt.payments.dao.pojos.aspects.TaskService.performJob())")
    private void perfomance() {
    }

    @Pointcut("execution(* by.st.opt.payments.dao.pojos.aspects.TaskService.performJob(String)) && args(name)")
    public void intercept(String name) {
    }

    @Before("perfomance()")
    public void beforeWork() {
        System.out.println("Execution before uunnamed work");
    }

    @AfterReturning("intercept(name)")
    public void afterWork(String name) {
        System.out.println("Execution after work: " + name);
    }
}
