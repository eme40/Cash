package com.eric.hello_cash.controller;


import com.eric.hello_cash.dto.RegistrationRequest;
import com.eric.hello_cash.dto.RegistrationResponse;
import com.eric.hello_cash.service.UserEntityService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class UserEntityController {

    private UserEntityService userEntityService;

    @Autowired
    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> create(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(userEntityService.registerUser(registrationRequest), HttpStatus.CREATED);
    }

}
