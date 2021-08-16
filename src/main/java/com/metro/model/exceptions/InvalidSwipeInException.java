package com.metro.model.exceptions;


public class InvalidSwipeInException extends Exception {
    public InvalidSwipeInException() {
        super("You have not Swiped Out from Previous Trip - Invalid Swipe In Action");
    }

    public InvalidSwipeInException(String message) {
        super(message);
    }
}
