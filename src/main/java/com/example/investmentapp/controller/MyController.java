package com.example.investmentapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {


    @GetMapping("/test")
    public String testWork(){
        return "TEST";
    }

}
