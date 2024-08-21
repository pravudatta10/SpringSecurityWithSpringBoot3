package com.springboot3.security.service;

import com.springboot3.security.entity.UserInfo;
import com.springboot3.security.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("********** Reached ******");
        Optional<UserInfo> uInfo = userInfoRepo.findByUserId(username);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (String s : uInfo.get().getRole().split(",")) {
            authorities.add(new SimpleGrantedAuthority(s));
        }
        System.out.println("********** Reached ******"+uInfo);
        return uInfo.map(userInfo -> User.builder()
                .username(userInfo.getUserId())
                .password(userInfo.getPassword())
                .authorities(authorities).build()).orElse(null);
    }
}