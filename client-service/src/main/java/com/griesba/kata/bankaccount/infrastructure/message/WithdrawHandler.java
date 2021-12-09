package com.griesba.kata.bankaccount.infrastructure.message;

import com.griesba.kata.bankaccount.commands.Withdraw;
import com.griesba.kata.bankaccount.infrastructure.EventStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CommandsProcessor.class)
public class WithdrawHandler extends CommandHandler{

    public WithdrawHandler(EventStore eventStore){
        super(eventStore);
    }

    @StreamListener(CommandsProcessor.WITHDRAW)
    public void withdrawHandler(Withdraw command) {
        execute(command);
    }
}
