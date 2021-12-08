package com.griesba.kata.bankaccount.events;

import javax.persistence.Id;
import java.util.UUID;

public abstract class Event {
    @Id
    private final UUID id;

    public Event(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
