/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.endpoint;

import com.baratest.entity.BaraUser;
import com.baratest.security.Secured;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author tareq
 */
@Path("test")
public class TestEndpoint {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public HashMap<String, String> testFunction() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Hello", "World");
        map.put("I", "Work");
        return map;
    }

    @GET
    @Path("secured")
    @Secured
    @Produces({MediaType.APPLICATION_JSON})
    public HashMap<String, String> securedFunction() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Hello", "World");
        map.put("I", "Work");
        map.put("I", "am");
        map.put("secured", "boyo");
        return map;
    }
    
    @GET
    @Path("context")
    @Secured
    @Produces({MediaType.APPLICATION_JSON})
    public BaraUser getMyUser(@Context SecurityContext sc){
        return (BaraUser)sc.getUserPrincipal();
    }

}
