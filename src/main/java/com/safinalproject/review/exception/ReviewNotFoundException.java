package com.safinalproject.review.exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException() {
    }

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
