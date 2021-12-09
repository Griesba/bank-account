package com.griesba.kata.bankaccount.commands;

import com.griesba.kata.bankaccount.events.WithdrawPerformed;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import com.griesba.kata.bankaccount.infrastructure.UnknownEventException;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Withdraw implements Command {

    private final String iban;
    private final double amount;

    public Withdraw(String iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }

    @Override
    public void execute(EventStore eventStore) {
        try {
            eventStore.append(new WithdrawPerformed(iban, amount));
        } catch (UnknownEventException e) {
            log.error("Error executing withdraw command", e);
        }
    }
}
