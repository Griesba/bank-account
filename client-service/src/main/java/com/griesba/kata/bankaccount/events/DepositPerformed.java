package com.griesba.kata.bankaccount.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DepositPerformed extends Event{

    private final String iban;
    public final double amount;
    private final UUID user;

    public DepositPerformed(UUID id, String iban, double amount, UUID user) {
        super(id);
        this.iban = iban;
        this.amount = amount;
        this.user = user;
    }
}
