package com.griesba.kata.bankaccount.events;

import lombok.Getter;
import java.util.UUID;

@Getter
public class BankAccountCreated extends Event{

    private final UUID user;
    private final String iban;

    public BankAccountCreated(String id, UUID user, String iban) {
        super(id);
        this.user = user;
        this.iban = iban;
    }
}
