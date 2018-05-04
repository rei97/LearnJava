package com.example.demo.service.interfaces;

import com.example.demo.domain.User;

public interface UserService {
    User getByUserName(String username);
    User getByUsernameAndPassword(String username, String password);
    User saveUser(String username, String password);
    Boolean isAuthenticated(String username, String password);
}
