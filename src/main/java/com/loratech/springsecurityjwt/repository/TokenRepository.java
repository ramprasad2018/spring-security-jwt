package com.loratech.springsecurityjwt.repository;

import com.loratech.springsecurityjwt.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query("SELECT u FROM Token u WHERE u.name = ?1 and u.password = ?2")
    Token findUserByNameAndPassword(String name, String password);

    @Query("SELECT u FROM Token u WHERE u.name = ?1")
    Token findUserByName(String name);

    @Modifying
    @Query("update Token u set u.token = ?1 where u.name = ?2")
    void updateTokenByUser(String token, String userName);

}
