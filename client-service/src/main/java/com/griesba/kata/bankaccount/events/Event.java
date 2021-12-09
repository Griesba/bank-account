package com.griesba.kata.bankaccount.events;

import javax.persistence.Id;
import java.util.UUID;

public abstract class Event {
    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }
}
