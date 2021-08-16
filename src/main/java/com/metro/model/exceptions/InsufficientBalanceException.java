package com.metro.model.exceptions;


public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException() {
        super("Your Card has Insufficient Balance \nPlease Recharge Your Card\nHappy Travelling\ud83d\ude01 ");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
