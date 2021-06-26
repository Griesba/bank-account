package com.kata.bankaccount.web.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AccountDto {
    private UUID id;
    private UUID userId;
    private double balance;
}
