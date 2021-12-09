package com.griesba.kata.bankaccount.infrastructure.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CommandsProcessor {
    String CREATE_BANK_ACCOUNT = "create-bank-account";
    String DEPOSIT = "deposit";
    String WITHDRAW = "withdraw";

    @Output(CommandsProcessor.CREATE_BANK_ACCOUNT)
    MessageChannel createBankAccountOutput();

    @Output(CommandsProcessor.DEPOSIT)
    MessageChannel depositOutput();

    @Output(CommandsProcessor.WITHDRAW)
    MessageChannel withdrawOutPut();

    @Input(CommandsProcessor.CREATE_BANK_ACCOUNT)
    MessageChannel creatBankAccountInput();

    @Input(CommandsProcessor.DEPOSIT)
    MessageChannel depositInput();

    @Input(CommandsProcessor.WITHDRAW)
    MessageChannel withdrawInput();

}
