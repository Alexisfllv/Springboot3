package com.edu.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
    //

        //error  padre
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleDefaultException (Exception e , WebRequest request) {
        CustomErrorResponse errorResponse =  new CustomErrorResponse
                (ZonedDateTime.now(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //error de parametros
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

//    //error de argumentos no validos
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValidException (MethodArgumentNotValidException e , WebRequest request) {
//        CustomErrorResponse errorResponse =  new CustomErrorResponse
//                (ZonedDateTime.now(),e.getMessage(),request.getDescription(false));
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

    //forma 2 de argumentos
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest req) {
        // return super.handleMethodArgumentNotValid(ex, headers, status, req);

        String messagelist =  ex.getBindingResult().getFieldErrors()
                .stream()
                .map(
                        error -> error.getField()+ ": " + error.getDefaultMessage()
                ).collect(Collectors.joining());

        String message = ex.getBindingResult().getFieldError().getDefaultMessage();

        CustomErrorResponse errorResponse =  new CustomErrorResponse
               (ZonedDateTime.now(),messagelist,req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
