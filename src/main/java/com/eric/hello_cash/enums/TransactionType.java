package com.eric.hello_cash.enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw"),
    TRANSFER("Transfer");

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }
}
