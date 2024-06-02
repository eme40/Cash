package com.eric.hello_cash.entities;

import com.eric.hello_cash.enums.AccountType;
import com.eric.hello_cash.utils.AccountNumberGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Account extends Audit{

    @NotBlank
    @Column(unique = true)
    private String accountNumber;

    @NotBlank
    private String accountName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    private BigDecimal balance;

    private boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Transaction> transactions;

    @PrePersist
    @PreUpdate
    public void setAccountName() {
        if (user != null) {
            this.accountName = user.getFullName();
        }
    }

}
