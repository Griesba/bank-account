package com.kata.bankaccount.web;

import com.kata.bankaccount.BankAccountException;
import com.kata.bankaccount.services.AccountServiceImpl;
import com.kata.bankaccount.web.model.AccountDto;
import com.kata.bankaccount.web.model.ClientActionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final AccountServiceImpl accountService;

    @GetMapping()
    public List<AccountDto> listAccount(){
        return accountService.listAccount();
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Object> deposit(@RequestBody ClientActionDto bankActionDto) {
        try {
            return ResponseEntity.ok(accountService.deposit(bankActionDto));
        } catch (BankAccountException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Object> withdraw(@RequestBody ClientActionDto bankActionDto) {
        try {
            return ResponseEntity.ok(accountService.withdraw(bankActionDto));
        } catch (BankAccountException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<ClientActionDto>> listAction(){
        return ResponseEntity.ok(accountService.listActions());
    }
}
