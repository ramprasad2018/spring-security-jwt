package com.loratech.springsecurityjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String token;

    public void setId(Integer id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setToken(String token) { this.token = token; }
    public Integer getId() {return id; }
    public String getName() { return name; }
    public String getToken() { return token; }
}
