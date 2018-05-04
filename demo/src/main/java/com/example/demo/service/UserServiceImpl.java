package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username).isPresent() ? userRepository.findByUsername(username).get() : null;
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).isPresent() ? userRepository.findByUsernameAndPassword(username, password).get() : null;
    }

    @Override
    public User saveUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Boolean isAuthenticated(String username, String password) {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if(userOptional.isPresent()) {
           return passwordEncoder.matches(password, userOptional.get().getPassword());
        }
        return false;
    }
}
