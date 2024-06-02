package com.eric.hello_cash.repository;

import com.eric.hello_cash.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
