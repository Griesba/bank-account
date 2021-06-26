package com.kata.bankaccount.web.mapper;


import com.kata.bankaccount.model.Account;
import com.kata.bankaccount.web.model.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountDto accountToDto(Account account);

    Account dtoToAccount(AccountDto accountDto);
}
