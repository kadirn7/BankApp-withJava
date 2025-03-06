package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.*;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.core.crossCuttingConcerns.exceptions.types.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HttpExceptionHandler implements com.banking.core.crossCuttingConcerns.exceptions.handlers.ExceptionHandler {

    @Override
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleException(Exception exception) {
        InternalServerErrorProblemDetails problemDetails = new InternalServerErrorProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(ValidationException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setValidationErrors(exception.getValidationErrors());
        problemDetails.setDetail("Validation Errors");
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
            validationErrors.put(error.getField(), error.getDefaultMessage())
        );
        problemDetails.setValidationErrors(validationErrors);
        problemDetails.setDetail("Validation Errors");
        return problemDetails;
    }
} 