package com.eric.hello_cash.service.impl;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;
import com.eric.hello_cash.entities.Wallet;
import com.eric.hello_cash.entities.UserEntity;
import com.eric.hello_cash.enums.Role;
import com.eric.hello_cash.repository.WalletRepository;
import com.eric.hello_cash.repository.UserEntityRepo;
import com.eric.hello_cash.service.UserEntityService;

import com.eric.hello_cash.utils.AccountNumberGenerator;
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
    private WalletRepository walletRepository;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepo userEntityRepo, WalletRepository walletRepository) {
        this.userEntityRepo = userEntityRepo;
        this.walletRepository = walletRepository;
    }

    @Override
    public RegistrationResponse registerUser(RegistrationRequest request) {
        // Create new UserEntity
        UserEntity newUser = UserEntity.builder()
                .firstName(request.getFirstName())
                .otherName(request.getOtherName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .role(Role.USER) // or other logic to determine the role
                .build();

        // Save the user to generate the user ID
        newUser = userEntityRepo.save(newUser);

        // Generate account number
        String accountNumber = AccountNumberGenerator.generateAccountNumber();

        // Create Wallet for the new user
        Wallet newWallet = Wallet.builder()
                .virtual_AccountNumber(accountNumber)
                .user(newUser)
                .accountType(request.getAccountType())
                .balance(BigDecimal.ZERO)
                .enabled(true)
                .build();

        // Save the wallet
        walletRepository.save(newWallet);


        return RegistrationResponse.builder()
                .accountNumber(accountNumber)
                .firstName(newUser.getFirstName())
                .build();
    }
}

