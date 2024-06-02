package com.eric.hello_cash.entities;

import com.eric.hello_cash.enums.BillStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String billName;

    @NotNull
    private BigDecimal amount;

    @CreatedDate
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private BillStatus status;

    @Future
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDateTime.now();
    }

}
