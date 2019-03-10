/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.endpoint;

import com.baratest.dao.BaraUserDao;
import com.baratest.entity.BaraUser;
import com.baratest.utils.LoginContainer;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tareq
 */
@Path("auth")
public class AuthEndpoint {
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public BaraUser login(LoginContainer login){
        return new BaraUserDao().login(login);
    }
}
