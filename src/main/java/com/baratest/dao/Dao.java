/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.dao;

import com.baratest.utils.EntityManagerFactoryWrapper;
import javax.persistence.EntityManager;

/**
 *
 * @author tareq
 */
public class Dao implements AutoCloseable{
    EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
 
    @Override
    public void close(){
    em.close();
    }
    
}
