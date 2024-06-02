package com.eric.hello_cash.enums;

import lombok.Getter;

@Getter
public enum AccountType {
    SAVING("Saving"),
    CURRENT("Current");

    private final String label;

    AccountType(String label) {
        this.label = label;
    }
}
