package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String index(
            @PathVariable(name = "name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public String singIn(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        if(username.equals("rei") && password.equals("12345" )) {
            return "Authenticated";
        } else {
            return "Not Authenticated ";

        }
    }

}
