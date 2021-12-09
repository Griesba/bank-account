package com.griesba.kata.bankaccount.infrastructure.message;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String message) {
        super(message);
    }
}
