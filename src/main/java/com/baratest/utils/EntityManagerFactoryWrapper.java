/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tareq
 */
public class EntityManagerFactoryWrapper {
    
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("bara_test_PU");
    
    public static EntityManager getEntityManager(){
      return EMF.createEntityManager();
    }
    
    public static void closeEntityManagerFactory(){
        EMF.close();
    }
}
