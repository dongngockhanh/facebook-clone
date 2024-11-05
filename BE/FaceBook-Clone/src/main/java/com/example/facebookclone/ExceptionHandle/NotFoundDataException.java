package com.example.facebookclone.ExceptionHandle;

public class NotFoundDataException extends RuntimeException{
    public NotFoundDataException(String message){
        super(message);
    }
}
