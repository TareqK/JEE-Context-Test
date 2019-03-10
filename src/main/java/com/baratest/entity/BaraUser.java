/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.baratest.entity;

import com.baratest.utils.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.security.Principal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author tareq
 */
@Entity
@Data
@NamedQueries({
    @NamedQuery(name="BaraUser.login", query="SELECT bu from BaraUser bu WHERE bu.username=(:user_name) AND bu.password=(:password)"),
    @NamedQuery(name="BaraUser.authorize", query = "SELECT bu from BaraUser bu WHERE bu.token=(:token)")
})
public class BaraUser implements Principal,Serializable{

    private static final String NAME = "%s %s";
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long userId;
    
    private String username;
    
    @Getter(onMethod_={@JsonIgnore})
    private String password;
    
    private String firstName;
    private String lastName;
    private String token;
    
    @Override
    public String getName() {
        return String.format(NAME,firstName,lastName);
    }
    
    public String generateToken(){
        this.token = Random.randomToken(48);
        return this.token;
    }
    
}
