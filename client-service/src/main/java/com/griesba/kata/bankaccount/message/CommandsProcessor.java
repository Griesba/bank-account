package com.griesba.kata.bankaccount.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CommandsProcessor {

    String CREATE_BANK_ACCOUNT = "commands.create-bank-account";
    String WITHDRAW = "commands.withdraw";
    String DEPOSIT = "commands.deposit";

    @Output(CommandsProcessor.CREATE_BANK_ACCOUNT)
    MessageChannel createBankAccountOutput();
}
