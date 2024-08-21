package com.springboot3.security.service;

import com.springboot3.security.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String generateToken(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserId(), loginDto.getPassword()));
        if (authenticate.isAuthenticated()) {
            return jwtUtil.generateToken(loginDto.getUserId());
        } else {
            return "User is Not Exist";
        }
    }
}