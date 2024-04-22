package com.example.homess.services;

import com.example.homess.dtos.SignupDto;
import com.example.homess.mappers.UserMapper;
import com.example.homess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserMapper userMapper;
    public void signup(SignupDto signupDto){
        if (signupDto.getUserPw() != null) {
            User user = User.builder()
                    .userName(signupDto.getUserName())
                    .userId(signupDto.getUserId())
                    .userPw(passwordEncoder.encode(signupDto.getUserPw()))
                    .nickname(signupDto.getNickname())
                    .birthdate(signupDto.getBirthdate())
                    .phonenumber(signupDto.getPhonenumber())
                    .email(signupDto.getEmail())
                    .build();

            userMapper.addUser(user);
        }
    }
}
