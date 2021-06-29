package com.kata.bankaccount.services;

import com.kata.bankaccount.BankAccountException;
import com.kata.bankaccount.web.model.AccountDto;
import com.kata.bankaccount.web.model.ClientActionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    List<AccountDto> listAccount();

    AccountDto withdraw(ClientActionDto bankActionDto) throws BankAccountException;

    AccountDto deposit(ClientActionDto bankActionDto) throws BankAccountException;

    List<ClientActionDto> listActions(UUID userId);
}
