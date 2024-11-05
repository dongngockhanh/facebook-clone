package com.example.facebookclone.ExceptionHandle;

import jakarta.persistence.Entity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> RuntimeExceptionHandle(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(NotFoundDataException.class)
    public ResponseEntity<?> NotFoundException(NotFoundDataException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(ExistingDataException.class)
    public ResponseEntity<?> ExistingException(ExistingDataException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
