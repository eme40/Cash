package com.eric.hello_cash.enums;

import lombok.Getter;

@Getter
public enum BillStatus {
    PENDING("Pending"),
    OVERDUE("Overdue"),
    PAID("Paid"),
    CANCELED("Canceled");

    private final String label;

    BillStatus(String label) {
        this.label = label;
    }

}

