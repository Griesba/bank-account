package com.griesba.kata.bankaccount.entities;

import com.griesba.kata.bankaccount.events.BankAccountCreated;
import com.griesba.kata.bankaccount.events.DepositPerformed;
import com.griesba.kata.bankaccount.events.WithdrawPerformed;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BankAccount extends Entity {

    private final UUID user;
    private final String iban;
    private final double balance;

    public BankAccount(UUID id, UUID user, String iban, Double balance) {
        super(id);
        this.user = user;
        this.iban = iban;
        this.balance = balance;
    }

    public static BankAccount reduce(BankAccountCreated event, BankAccount bankAccount){
        return new BankAccount(null, event.getUser(), event.getIban(), 0d);
    }

    public static BankAccount reduce(WithdrawPerformed event, BankAccount bankAccount){
        double amount = bankAccount.balance  - event.getAmount();
        return new BankAccount(event.getId(), event.getUser(), event.getIban(), amount);
    }

    public static BankAccount reduce(DepositPerformed event, BankAccount bankAccount){
        double amount = bankAccount.balance  + event.getAmount();
        return new BankAccount(event.getId(), event.getUser(), event.getIban(), amount);
    }

}
