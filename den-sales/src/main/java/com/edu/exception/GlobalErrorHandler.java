package com.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalErrorHandler {
    //

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException e , WebRequest request) {
        CustomErrorResponse errorResponse =  new CustomErrorResponse
                (ZonedDateTime.now(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    //Desde Springboot 3+
//    @ExceptionHandler(ModelNotFoundException.class)
//    public ProblemDetail handleModelNotFoundException(ModelNotFoundException e , WebRequest request) {
//        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
//        pd.setTitle("Model not found");
//        pd.setType(URI.create(request.getContextPath()));
//        pd.setProperty("code", HttpStatus.NOT_FOUND.value());
//        return pd;
//
//    }

}
