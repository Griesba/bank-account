package com.griesba.kata.bankaccount.web;

import com.griesba.kata.bankaccount.BankAccountException;
import com.griesba.kata.bankaccount.config.PropertiesConfig;
import com.griesba.kata.bankaccount.services.AccountServiceImpl;
import com.griesba.kata.bankaccount.web.model.AccountDto;
import com.griesba.kata.bankaccount.web.model.ClientActionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/account")
@RestController
@RequiredArgsConstructor
public class BankAccountController {

    private final AccountServiceImpl accountService;
    private final PropertiesConfig propertiesConfig;

    @GetMapping()
    public List<AccountDto> listAccount(){
        return accountService.listAccount();
    }

    @PostMapping
    public boolean createAccount(@RequestBody AccountDto accountDto){

        return propertiesConfig.isUseCQRS() ? accountService.send(accountDto) : accountService.createAccount(accountDto) != null ;
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

    @GetMapping("/history{userId}")
    public ResponseEntity<List<ClientActionDto>> listAction(@RequestParam UUID userId){
        return ResponseEntity.ok(accountService.listActions(userId));
    }
}
