package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users")
public class UserController {


    
    @GetMapping("/list")
    public String list(){
        return "Rest funcionando";
    }

    
}
