package com.eric.hello_cash.service;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;

public interface UserEntityService {
    RegistrationResponse registerUser(RegistrationRequest request);
}
