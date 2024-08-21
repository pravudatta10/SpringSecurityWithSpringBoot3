package com.springboot3.security.controller;

import com.springboot3.security.dto.LoginDto;
import com.springboot3.security.entity.UserInfo;
import com.springboot3.security.service.AuthService;
import com.springboot3.security.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AuthService authService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @GetMapping("/secure")
    public String secure() {
        return "It is a Secure End Point";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody LoginDto loginDto) {
        return authService.generateToken(loginDto);
    }
}