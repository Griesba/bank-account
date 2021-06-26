package com.kata.bankaccount.web;

import com.kata.bankaccount.services.AccountService;
import com.kata.bankaccount.web.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/account")
@RestController
@RequiredArgsConstructor
public class BankAccountController {

    private final AccountService accountService;

    @GetMapping()
    public List<AccountDto> listAccount(){
        return accountService.listAccount();
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }
}
