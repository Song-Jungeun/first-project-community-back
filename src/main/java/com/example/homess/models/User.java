package com.example.homess.models;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
public class User {
    private int uid;
    private String userName;
    private String userId;
    private String userPw;
    private String nickname;
    private Date birthdate;
    private String phonenumber;
    private String email;
    private String grade;
    private char deleteyn;
    private LocalDateTime signupDate;
}