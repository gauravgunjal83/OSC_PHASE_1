package com.in.exception;

public class EmptyResultException extends  RuntimeException {

    public EmptyResultException(String message){
        super(message);
    }
}