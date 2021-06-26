package com.kata.bankaccount.services;

import com.kata.bankaccount.model.Account;
import com.kata.bankaccount.repo.AccountRepository;
import com.kata.bankaccount.web.mapper.AccountMapper;
import com.kata.bankaccount.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setUserId(accountDto.getUserId());
        account.setBalance(accountDto.getBalance());
        return accountMapper.accountToDto(accountRepository.save(account));
    }

    public List<AccountDto> listAccount() {
        return accountRepository.findAll().stream().map(accountMapper::accountToDto).collect(Collectors.toList());
    }
}
