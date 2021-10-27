package com.example.Therapy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ExceptionsHandler {
    @ExceptionHandler({PatientNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(PatientNotFoundException exception) {
        return new HttpErrorResponse(
                404,
                "This patient is not in our data base",
                LocalDateTime.now()
        );
    }
    @ExceptionHandler({PhoneNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpErrorResponse handleGenericException(PhoneNotFoundException exception) {
        return new HttpErrorResponse(
                400,
                "This is a wrong patient phone/not found",
                LocalDateTime.now()
        );
    }}