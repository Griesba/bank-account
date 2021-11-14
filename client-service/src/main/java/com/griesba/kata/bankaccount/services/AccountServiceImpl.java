package com.griesba.kata.bankaccount.services;

import com.griesba.kata.bankaccount.BankAccountException;
import com.griesba.kata.bankaccount.model.Account;
import com.griesba.kata.bankaccount.repo.AccountRepository;
import com.griesba.kata.bankaccount.repo.ClientActionHistory;
import com.griesba.kata.bankaccount.web.mapper.AccountMapper;
import com.griesba.kata.bankaccount.model.ClientAction;
import com.griesba.kata.bankaccount.web.mapper.ClientActionMapper;
import com.griesba.kata.bankaccount.web.model.AccountDto;
import com.griesba.kata.bankaccount.web.model.ClientActionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ClientActionHistory actionHistory;
    private final ClientActionMapper actionMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setUserId(accountDto.getUserId());
        account.setBalance(accountDto.getBalance());
        AccountDto result = accountMapper.accountToDto(accountRepository.save(account));

        return result;
    }

    @Override
    public List<AccountDto> listAccount() {
        return accountRepository.findAll().stream().map(accountMapper::accountToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public synchronized AccountDto withdraw(ClientActionDto actionDto) throws BankAccountException {
        Optional<Account> accountOpt = accountRepository.findById(actionDto.getAccountId());
        if (accountOpt.isEmpty()) {
            throw new BankAccountException("Bank account not found");
        }
        if(actionDto.getAmount() > accountOpt.get().getBalance()){
            throw new BankAccountException("Insufficient balance");
        }
        ClientAction clientAction = actionMapper.dtoToClientAction(actionDto);
        clientAction.setAmount(-1*clientAction.getAmount());
        actionHistory.save(clientAction);
        Account account = accountOpt.get();
        account.setBalance(account.getBalance() - actionDto.getAmount());
        return accountMapper.accountToDto(accountRepository.save(account));
    }

    @Override
    @Transactional
    public synchronized AccountDto deposit(ClientActionDto actionDto) throws BankAccountException {
        Optional<Account> accountOpt = accountRepository.findById(actionDto.getAccountId());
        if (accountOpt.isEmpty()) {
            throw new BankAccountException("Bank account not found");
        }
        actionHistory.save(actionMapper.dtoToClientAction(actionDto));
        Account account = accountOpt.get();
        account.setBalance(account.getBalance() + actionDto.getAmount());
        return accountMapper.accountToDto(accountRepository.save(account));
    }

    @Override
    public List<ClientActionDto> listActions(UUID userId) {
        return actionHistory.findAllByUserId(userId)
                .stream().map(actionMapper::clientActionToDto)
                .collect(Collectors.toList());

    }
}
