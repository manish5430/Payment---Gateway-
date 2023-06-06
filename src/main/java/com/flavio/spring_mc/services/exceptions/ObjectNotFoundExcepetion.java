package com.flavio.spring_mc.services.exceptions;

public class ObjectNotFoundExcepetion extends RuntimeException {

    public ObjectNotFoundExcepetion(String msg){
        super(msg);
    }

    public ObjectNotFoundExcepetion(String msg, Throwable cause){
        super(msg, cause);
    }
}
