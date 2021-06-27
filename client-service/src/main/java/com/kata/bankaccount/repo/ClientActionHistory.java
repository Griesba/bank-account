package com.kata.bankaccount.repo;

import com.kata.bankaccount.model.ClientAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientActionHistory extends JpaRepository<ClientAction, UUID> {
}
