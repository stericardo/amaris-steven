package com.amaris.steven.test.exception;

public class BrandNotFoundException extends RuntimeException{

    public BrandNotFoundException(String message){
        super(message);
    }

}
