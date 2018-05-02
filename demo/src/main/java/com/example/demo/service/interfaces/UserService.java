package com.example.demo.service.interfaces;

import com.example.demo.domain.User;

public interface UserService {
    User getByUserName(String username);
    User saveUser(String username, String password);
}
