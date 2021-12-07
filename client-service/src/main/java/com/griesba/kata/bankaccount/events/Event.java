package com.griesba.kata.bankaccount.events;

import javax.persistence.Id;

public abstract class Event {
    @Id
    private final String id;

    public Event(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
