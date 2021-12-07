package com.griesba.kata.bankaccount.services;

import com.griesba.kata.bankaccount.BankAccountException;
import com.griesba.kata.bankaccount.web.model.AccountDto;
import com.griesba.kata.bankaccount.web.model.ClientActionDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> listAccount();

    AccountDto withdraw(ClientActionDto bankActionDto) throws BankAccountException;

    AccountDto deposit(ClientActionDto bankActionDto) throws BankAccountException;

    List<ClientActionDto> listActions(UUID userId);

    boolean send(AccountDto accountDto);
}
