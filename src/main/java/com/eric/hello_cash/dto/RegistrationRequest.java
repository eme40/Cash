package com.eric.hello_cash.dto;

import com.eric.hello_cash.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private String phoneNumber;
    private AccountType accountType;
}
