package com.griesba.kata.bankaccount.entities;

import lombok.Value;

import javax.persistence.Id;

public abstract class Entity {
    @Id
    private final String id;

    protected Entity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
