package com.griesba.kata.bankaccount.commands;

import com.griesba.kata.bankaccount.events.BankAccountCreated;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import com.griesba.kata.bankaccount.infrastructure.UnknownEventException;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CreateBankAccount implements Command {
    private final UUID user;
    private final String iban;

    public CreateBankAccount(UUID user, String iban) {
        this.user = user;
        this.iban = iban;
    }

    @Override
    public void execute(EventStore eventStore) {
        try {
            eventStore.append(new BankAccountCreated(user, iban));
        } catch (UnknownEventException e) {
            log.error("Error creating bank account command", e);
        }
    }
}
