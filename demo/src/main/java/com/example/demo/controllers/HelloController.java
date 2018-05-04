package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String index(
            @PathVariable(name = "name") String name) {
        return "Hello " + name;
    }
    // Test change
    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public Boolean singIn(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
       return userService.isAuthenticated(username, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public void signUp(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        userService.saveUser(username,password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/develop")
    public String develop() {
        return "Branch develop";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/divide/{a}/{b}" )
    public String divide(@PathVariable String a, @PathVariable String b) {
        try {
          return String.valueOf(Double.parseDouble(a)/Double.parseDouble(b));
        }
        catch(NumberFormatException nfx){
            return "Format number error";
        }
    }



}
