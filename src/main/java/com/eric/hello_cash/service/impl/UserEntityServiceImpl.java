package com.eric.hello_cash.service.impl;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;
import com.eric.hello_cash.entities.Account;
import com.eric.hello_cash.entities.UserEntity;
import com.eric.hello_cash.repository.AccountRepo;
import com.eric.hello_cash.repository.UserEntityRepo;
import com.eric.hello_cash.service.UserEntityService;

import com.eric.hello_cash.utils.AccountNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepo userEntityRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public RegistrationResponse createUser(RegistrationRequest request) {
        log.info("Creating user with request: {}", request);

        // Generate account number
        String accountNumber = AccountNumberGenerator.generateAccountNumber();

        UserEntity newUser = UserEntity.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .otherName(request.getOtherName())
                .BVN(request.getBVN())
                .dateOfBirth(request.getDateOfBirth())
                .nationality(request.getNationality())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber())// Ensure accounts list is initialized
                .build();

        UserEntity savedUser = userEntityRepo.save(newUser);

        log.info("New user created: {}", newUser);

        // Create a new account associated with the user
        Account account = Account.builder()
                .accountNumber(accountNumber)
                .accountName(newUser.getFullName())
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO) // Initial balance can be set here
                .enabled(true) // Enabled by default
                .user(newUser)
                .build();

        log.info("New account created: {}", account);

        // Add the account to the user
        accountRepo.save(account);
        log.info("Account added to user: {}", newUser.getAccounts());



        log.info("User saved: {}", savedUser);

        return RegistrationResponse.builder()
                .firstName(savedUser.getFirstName())
                .accountNumber(accountNumber)
                .build();
    }
}
