/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.security;

import com.baratest.entity.BaraUser;
import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author tareq
 */
public class BaraSecurityContext implements SecurityContext{

    private final BaraUser user;

    public BaraSecurityContext(BaraUser user) {
        this.user= user;
    }
    @Override
    public Principal getUserPrincipal() {
        return user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getAuthenticationScheme() {
        return "Bearer Token";
    }
    
}
