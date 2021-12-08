package com.griesba.kata.bankaccount.commands;

import com.griesba.kata.bankaccount.infrastructure.EventStore;

public interface Command {
    void execute(EventStore eventStore);
}
