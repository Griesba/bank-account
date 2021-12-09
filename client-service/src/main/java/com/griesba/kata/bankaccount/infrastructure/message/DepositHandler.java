package com.griesba.kata.bankaccount.infrastructure.message;

import com.griesba.kata.bankaccount.commands.Deposit;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class DepositHandler extends CommandHandler{

    public DepositHandler(EventStore eventStore){
        super(eventStore);
    }

    @StreamListener(CommandsProcessor.DEPOSIT)
    public void handleDeposit(Deposit command){
        execute(command);
    }
}
