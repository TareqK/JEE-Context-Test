/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.endpoint;

import com.baratest.dao.BaraUserDao;
import com.baratest.security.BaraSecurityContext;
import com.baratest.security.Secured;
import java.io.IOException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author tareq
 */
@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;
    private static final String BEARER = "Bearer";
    private static final String AUTHORIZATION = "Authorization";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (resourceInfo.getResourceMethod().getAnnotation(Secured.class) != null) {
            String authorizationHeader = requestContext.getHeaders().getFirst(AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.contains(BEARER)) {
                String token = authorizationHeader.substring(authorizationHeader.indexOf(BEARER) + BEARER.length()).trim();
                try {
                    requestContext
                            .setSecurityContext(
                                    new BaraSecurityContext(
                                            new BaraUserDao()
                                                    .authorize(token)));
                } catch (WebApplicationException ex) {
                    requestContext.abortWith(ex.getResponse());
                }
            } else {
                requestContext.abortWith(new WebApplicationException(401).getResponse());
            }
        }
    }
}
