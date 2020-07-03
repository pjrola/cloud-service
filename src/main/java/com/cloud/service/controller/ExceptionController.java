package com.cloud.service.controller;

import com.cloud.service.exception.DuplicateResourceException;
import com.cloud.service.exception.ExceptionResponse;
import com.cloud.service.exception.LockedException;
import com.cloud.service.exception.ResourceNotFoundException;
import com.cloud.service.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Locale;

@ControllerAdvice
public class ExceptionController {

    private final MessageSource messageSource;

    @Autowired
    public ExceptionController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex, Locale locale) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.setErrorMessage(messageSource.getMessage("exception.not.found", new Object[] {
                ex.getProperty(),
        }, locale));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setErrorMessage(messageSource.getMessage("invalid.input", new Object[] {
                ex.getMessage(),
        }, locale));
        response.setErrors(ValidationUtil.fromBindingErrors(result));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> resourceLock(LockedException ex, Locale locale) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(String.valueOf(HttpStatus.CONFLICT.value()));
        response.setErrorMessage(messageSource.getMessage("exception.resource.locked", new Object[] {
                ex.getProperty(),
        }, locale));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}