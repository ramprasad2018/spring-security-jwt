package com.loratech.springsecurityjwt.services;

import com.loratech.springsecurityjwt.entity.Token;
import com.loratech.springsecurityjwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {


        Token token = new Token();
        token = tokenService.getUserByName(userName);
        String uName =  null;
        String password = null;
        if (token != null)
        {
            uName = token.getName();
            password = token.getPassword();
        }
        return new User(uName,password, new ArrayList<>());
       // return new User("ram","password", new ArrayList<>());
    }
}
