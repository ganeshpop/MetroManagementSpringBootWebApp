package com.metro.model.exceptions;


public class InvalidStationException extends Exception {
    public InvalidStationException() {
        super("You Have Selected an Invalid Station, Please Try Again");
    }

    public InvalidStationException(String message) {
        super(message);
    }
}
