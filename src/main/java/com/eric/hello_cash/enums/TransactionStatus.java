package com.eric.hello_cash.enums;

import lombok.Getter;

@Getter
public enum TransactionStatus {
    PENDING("Pending"),
    COMPLETED("Complete"),
    FAILED("Failed");

    private final String label;

    TransactionStatus(String label) {
        this.label = label;
    }

}
