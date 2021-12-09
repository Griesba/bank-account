package com.griesba.kata.bankaccount.commands;

import com.griesba.kata.bankaccount.events.DepositPerformed;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import com.griesba.kata.bankaccount.infrastructure.UnknownEventException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Deposit implements Command {
    private final String iban;
    private final double amount;

    public Deposit(String iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public void execute(EventStore eventStore) {
        try {
            eventStore.append(new DepositPerformed(iban, amount));
        } catch (UnknownEventException e) {
            log.error("Error executing Deposit command", e);
        }
    }
}
