package com.griesba.kata.bankaccount.events;

import lombok.Getter;

@Getter
public class WithdrawPerformed extends Event{
    private final String iban;
    private final double amount;

    public WithdrawPerformed(String iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }
}
