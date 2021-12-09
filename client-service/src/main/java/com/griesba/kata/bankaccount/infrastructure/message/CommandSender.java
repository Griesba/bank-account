package com.griesba.kata.bankaccount.infrastructure.message;

import com.griesba.kata.bankaccount.commands.Command;
import com.griesba.kata.bankaccount.commands.Withdraw;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CommandsProcessor.class)
public class CommandSender {
    private final CommandsProcessor router;

    public CommandSender(CommandsProcessor router) {
        this.router = router;
    }

    public boolean send(Command command) throws UnknownCommandException {
        Message<Command> message = MessageBuilder.withPayload(command).build();
        switch (command.getClass().getSimpleName()) {
            case "CreateBankAccount":
                return router.createBankAccountOutput().send(message);
            case "Deposit":
                return router.depositOutput().send(message);
            case "Withdraw":
                return router.withdrawOutPut().send(message);
            default: throw new UnknownCommandException("Error: command unknown");
        }
    }

    public boolean send(Withdraw command) {
        return router.creatBankAccountInput().send(MessageBuilder.withPayload(command).build());
    }
}
