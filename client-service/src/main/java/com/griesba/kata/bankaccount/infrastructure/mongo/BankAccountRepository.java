package com.griesba.kata.bankaccount.infrastructure.mongo;

import com.griesba.kata.bankaccount.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
}
