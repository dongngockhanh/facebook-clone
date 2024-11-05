package com.example.facebookclone.ExceptionHandle;

public class ExistingDataException extends RuntimeException{
    public ExistingDataException(String message){
        super(message);
    }
}
