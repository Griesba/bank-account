package com.griesba.kata.bankaccount.infrastructure.message;

import com.griesba.kata.bankaccount.commands.CreateBankAccount;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class CreateBankAccountHandler extends CommandHandler {

    public CreateBankAccountHandler(EventStore eventStore) {
        super(eventStore);
    }

    @StreamListener(CommandsProcessor.CREATE_BANK_ACCOUNT)
    public void handleCreateBankAccount(CreateBankAccount command) {
        execute(command);
    }
}
