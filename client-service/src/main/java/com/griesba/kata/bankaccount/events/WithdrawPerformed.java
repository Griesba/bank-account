package com.griesba.kata.bankaccount.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class WithdrawPerformed extends Event{
    private final String iban;
    private final double amount;
    private final UUID user;

    public WithdrawPerformed(UUID id, String iban, double amount, UUID user) {
        super(id);
        this.iban = iban;
        this.amount = amount;
        this.user = user;
    }
}
