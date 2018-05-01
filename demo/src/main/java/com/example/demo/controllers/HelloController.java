package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public String index(
            @PathVariable(name = "name") String name) {
        return "Hello " + name;
    }

    }

}
