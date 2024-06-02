package com.eric.hello_cash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {
    private String accountNumber;
    private String firstName;
}
