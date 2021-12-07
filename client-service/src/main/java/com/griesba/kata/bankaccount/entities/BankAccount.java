package com.griesba.kata.bankaccount.entities;

import com.griesba.kata.bankaccount.events.BankAccountCreated;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BankAccount extends Entity{

    private final UUID user;
    private final String iban;
    private final Double balance;

    public BankAccount(String id, UUID user, String iban, Double balance) {
        super(id);
        this.user = user;
        this.iban = iban;
        this.balance = balance;
    }

    public static BankAccount reduce(BankAccountCreated event, BankAccount bankAccount){
        return new BankAccount(null, event.getUser(), event.getIban(), 0d);
    }

}
