package com.eric.hello_cash.service.impl;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;
import com.eric.hello_cash.entities.Wallet;
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

@Service
@NoArgsConstructor
@Slf4j
public class UserEntityServiceImpl implements UserEntityService {

    private UserEntityRepo userEntityRepo;
    private AccountRepo accountRepo;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepo userEntityRepo, AccountRepo accountRepo) {
        this.userEntityRepo = userEntityRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public RegistrationResponse createUser(RegistrationRequest request) {
        log.info("Creating user with request: {}", request);
        UserEntity newUser = UserEntity.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .otherName(request.getOtherName())
                .phoneNumber(request.getPhoneNumber())// Ensure accounts list is initialized
                .build();
        UserEntity savedUser = userEntityRepo.save(newUser);
        log.info("New user created: {}", newUser);
        // Create a new account associated with the user
        Wallet account = Wallet.builder()
                .accountName(newUser.getFullName())
                .virtual_AccountNumber(AccountNumberGenerator.generateAccountNumber())
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO) // Initial balance can be set here
                .enabled(true) // Enabled by default
                .user(newUser)
                .build();
        log.info("New account created: {}", account);
        // Add the account to the user
        log.info("Account added to user: {}", newUser.getAccounts());
        Wallet SavedWallet = accountRepo.save(account);
        log.info("User saved: {}", savedUser);
        return RegistrationResponse.builder()
                .firstName(savedUser.getFirstName())
                .accountNumber(SavedWallet.getVirtual_AccountNumber())
                .build();
    }
}
