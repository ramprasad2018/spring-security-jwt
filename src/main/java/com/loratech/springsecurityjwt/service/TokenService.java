package com.loratech.springsecurityjwt.service;

import com.loratech.springsecurityjwt.entity.Token;
import com.loratech.springsecurityjwt.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    @Autowired
    private TokenRepository repository;

    public Token addOrder(Token token){
        return repository.save(token);
    }

    public List<Token> getOrders(){
        return repository.findAll();
    }

    public Token getUserById(int id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
    }

    public Token isValidUser(String name, String password) {

        return repository.findUserByNameAndPassword(name,password);

    }

    public Token getUserByName(String name){
        return repository.findUserByName(name);
    }

    public void updateTokenByUser(String Token, String User){
        try{
           Token token = new Token();
           token = repository.findUserByName(User);
           token.setToken(Token);
           repository.save(token);
        }
        catch(Exception ex){
           throw ex;
        }


    }
}
