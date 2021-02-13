package com.exam.exam.exceptionhandler;

import com.exam.exam.exception.SameBookException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookControllerAdvice {
    @ExceptionHandler({SameBookException.class})
    public ResponseEntity handle(SameBookException same){
        return ResponseEntity.badRequest().body(same.getMessage());
    }



}
