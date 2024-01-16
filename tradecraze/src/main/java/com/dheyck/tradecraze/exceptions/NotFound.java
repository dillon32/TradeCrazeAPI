package com.dheyck.tradecraze.exceptions;

public class NotFound extends RuntimeException {

    private static final long serialVerisionUID = 1;

    public NotFound(String message) {
        super(message);
    }
}
