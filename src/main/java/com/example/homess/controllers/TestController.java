package com.example.homess.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String getTest(){
        return "Hello Get";
    }

    @PostMapping("/test")
    public String postTest(){
        int userUid = (int)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userUid);
        return "Hello Post";
    }
}
