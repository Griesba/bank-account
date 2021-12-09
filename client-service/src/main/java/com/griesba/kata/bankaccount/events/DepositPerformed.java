package com.griesba.kata.bankaccount.events;

import lombok.Getter;

@Getter
public class DepositPerformed extends Event{

    private final String iban;
    public final double amount;

    public DepositPerformed(String iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }
}
