package com.eric.hello_cash.entities;


import com.eric.hello_cash.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)


public class UserEntity extends BaseClass {

    private String firstName;
    private String otherName;
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wallet accounts;
    private Role role;

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


