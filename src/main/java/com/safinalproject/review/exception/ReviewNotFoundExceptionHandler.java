package com.safinalproject.review.exception;

import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReviewNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ReviewNotFoundException.class})
    public ResponseEntity<Object> handleReviewException(Exception e, WebRequest request){
        return handleExceptionInternal(e, "Review not found", new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }
}
