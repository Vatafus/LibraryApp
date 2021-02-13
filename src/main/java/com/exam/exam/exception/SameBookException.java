package com.exam.exam.exception;


public class SameBookException extends RuntimeException {
    public SameBookException(){
        super("There is already a book with the same title, publisher and publishing year");
    }
}
