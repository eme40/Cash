package com.eric.hello_cash.repository;

import com.eric.hello_cash.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}
