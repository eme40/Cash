package com.eric.hello_cash.repository;

import com.eric.hello_cash.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
