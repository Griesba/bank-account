package com.griesba.kata.bankaccount.web.mapper;


import com.griesba.kata.bankaccount.model.Account;
import com.griesba.kata.bankaccount.web.model.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountDto accountToDto(Account account);

    Account dtoToAccount(AccountDto accountDto);
}
