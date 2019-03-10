/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.dao;

import com.baratest.entity.BaraUser;
import com.baratest.utils.LoginContainer;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author tareq
 */
public class BaraUserDao extends Dao {

    public BaraUser login(LoginContainer login) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        try {
            BaraUser user = em.createNamedQuery("BaraUser.login", BaraUser.class)
                    .setParameter("user_name", login.getUsername())
                    .setParameter("password", login.getPassword())
                    .getSingleResult();
            user.generateToken();
            return user;
        } catch (NoResultException ex) {
            throw new WebApplicationException(403);
        } finally {
            t.commit();
        }
    }

    public BaraUser authorize(String token) {
        try {
            return em.createNamedQuery("BaraUser.authorize", BaraUser.class)
                    .setParameter("token", token)
                    .getSingleResult();
        } catch (NoResultException ex) {
            throw new WebApplicationException(403);
        }
    }
}
