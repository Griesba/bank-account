package com.griesba.kata.bankaccount.infrastructure;

public class UnknownEventException extends Exception {
    public UnknownEventException(String message) {
        super(message);
    }
}
