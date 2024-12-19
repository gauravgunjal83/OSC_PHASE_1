package com.in.exception;

import jakarta.validation.constraints.Null;

public class NullPointerException extends RuntimeException {

    public NullPointerException(String msg) {
        super(msg);
    }
}
