/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.run;

import com.baratest.utils.EntityManagerFactoryWrapper;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 *
 * @author tareq
 */
@WebListener
public class Initialization implements ServletContextListener{

    private static final Logger LOG = Logger.getLogger(Initialization.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactoryWrapper.getEntityManager();
        LOG.info("Application Started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactoryWrapper.closeEntityManagerFactory();
        LOG.info("Application Stopped");
    }
    
}
