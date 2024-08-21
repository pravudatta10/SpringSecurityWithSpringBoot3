package com.springboot3.security.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String userId;
    private String password;
}