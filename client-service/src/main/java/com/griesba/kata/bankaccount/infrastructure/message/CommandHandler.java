package com.griesba.kata.bankaccount.infrastructure.message;

import com.griesba.kata.bankaccount.commands.Command;
import com.griesba.kata.bankaccount.infrastructure.EventStore;

public abstract class CommandHandler {

    private final EventStore eventStore;

    public CommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    protected void execute(Command command) {
        command.execute(eventStore);
    }
}
