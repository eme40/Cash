package com.eric.hello_cash.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Builder

@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)


public class UserEntity extends Audit{
    private String firstName;
    private String lastName;
    private String otherName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password; // hashed and encrypted
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String BVN;
    private String OTP;
    private String image;
    private Integer loginAttempt;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Bill> bills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Account> accounts;

    public UserEntity() {
        this.accounts = new ArrayList<>();
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        if (firstName != null && !firstName.isEmpty()) {
            fullName.append(firstName);
        }
        if (otherName != null && !otherName.isEmpty()) {
            if (!fullName.isEmpty()) {
                fullName.append(" ");
            }
            fullName.append(otherName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            if (!fullName.isEmpty()) {
                fullName.append(" ");
            }
            fullName.append(lastName);
        }
        return fullName.toString();
    }

}


