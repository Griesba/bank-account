package com.griesba.kata.bankaccount.repo;

import com.griesba.kata.bankaccount.model.ClientAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientActionHistory extends JpaRepository<ClientAction, UUID> {

    List<ClientAction> findAllByUserId(UUID userId);
}
