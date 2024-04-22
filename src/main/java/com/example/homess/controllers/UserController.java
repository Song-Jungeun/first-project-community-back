package com.example.homess.controllers;

import com.example.homess.dtos.SignupDto;
import com.example.homess.mappers.UserMapper;
import com.example.homess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto){
        userService.signup(signupDto);
        System.out.println(signupDto.getUserName());
        System.out.println(signupDto.getUserId());
        System.out.println(signupDto.getUserPw());
        System.out.println(signupDto.getNickname());
        System.out.println(signupDto.getBirthdate());
        System.out.println(signupDto.getPhonenumber());
        System.out.println(signupDto.getEmail());
    }

}

