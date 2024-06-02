package com.eric.hello_cash.controller;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;
import com.eric.hello_cash.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/register")
    public RegistrationResponse create(@RequestBody RegistrationRequest registrationRequest){
        return userEntityService.createUser(registrationRequest);
    }

}
