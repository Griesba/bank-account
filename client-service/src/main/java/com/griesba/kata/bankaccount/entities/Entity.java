package com.griesba.kata.bankaccount.entities;

import lombok.Value;

import javax.persistence.Id;
import java.util.UUID;

public abstract class Entity {
    @Id
    private final UUID id;

    protected Entity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
