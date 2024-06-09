package com.eric.hello_cash.entities;

import com.eric.hello_cash.enums.TransactionStatus;
import com.eric.hello_cash.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
@Entity
public class Transaction extends BaseClass {
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private BigDecimal amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Wallet account;
}
