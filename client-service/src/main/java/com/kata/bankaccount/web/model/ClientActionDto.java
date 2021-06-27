package com.kata.bankaccount.web.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ClientActionDto {
    private UUID id;
    private UUID accountId;
    private UUID userId;
    private double amount;
    OffsetDateTime execTime;
}
