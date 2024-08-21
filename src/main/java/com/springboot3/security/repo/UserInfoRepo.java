package com.springboot3.security.repo;

import com.springboot3.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {
    Optional<UserInfo> findByUserId(String username);

    List<String> findByRole(String userId);
}