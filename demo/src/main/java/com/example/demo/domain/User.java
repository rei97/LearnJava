package com.example.demo.domain;

import com.example.demo.domain.abstracts.AbstractBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "USER")
public class User extends AbstractBase {

    @Column(unique = true, nullable = false, length = 20)
    private String username;
    @Column(length = 255)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
