package com.griesba.kata.bankaccount.infrastructure;

import com.griesba.kata.bankaccount.entities.BankAccount;
import com.griesba.kata.bankaccount.events.BankAccountCreated;
import com.griesba.kata.bankaccount.events.DepositPerformed;
import com.griesba.kata.bankaccount.events.Event;
import com.griesba.kata.bankaccount.events.WithdrawPerformed;
import com.griesba.kata.bankaccount.infrastructure.mongo.BankAccountRepository;
import org.springframework.stereotype.Component;

@Component
public class EntityReducer {
    private final BankAccountRepository bankAccountRepository;

    public EntityReducer(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public void reduce(Event event) throws UnknownEventException {
        if (event instanceof BankAccountCreated) {
            bankAccountRepository.save(BankAccount.reduce((BankAccountCreated)event,currentBankAccount(event)));
        } else if (event instanceof WithdrawPerformed) {
            bankAccountRepository.save(BankAccount.reduce((WithdrawPerformed) event, currentBankAccount(event)));
        } else if (event instanceof DepositPerformed) {
            bankAccountRepository.save(BankAccount.reduce((DepositPerformed) event, currentBankAccount(event)));
        } else throw new UnknownEventException("Error: unknown event " + event.getId().toString());
    }

    private BankAccount currentBankAccount(Event event){
        return bankAccountRepository.findById(event.getId()).orElse(null);
    }
}
