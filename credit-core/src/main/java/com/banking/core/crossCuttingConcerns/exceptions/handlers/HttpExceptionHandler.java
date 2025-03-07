package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.*;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.core.crossCuttingConcerns.exceptions.types.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.banking")
public class HttpExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleException(Exception exception) {
        InternalServerErrorProblemDetails problemDetails = new InternalServerErrorProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        problemDetails.setTitle("Internal Server Error");
        problemDetails.setType("https://example.com/probs/internal");
        problemDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        problemDetails.setInstance(exception.getClass().getName());
        return new ResponseEntity<>(problemDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<ProblemDetails> handleDataIntegrityViolationException(org.springframework.dao.DataIntegrityViolationException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        String detail = exception.getMostSpecificCause().getMessage();
        if (detail.contains("customer_number")) {
            detail = "Customer number already exists or cannot be null";
        } else if (detail.contains("email")) {
            detail = "Email address already exists or cannot be null";
        } else if (detail.contains("phone_number")) {
            detail = "Phone number already exists or cannot be null";
        }
        problemDetails.setDetail(detail);
        problemDetails.setTitle("Database Constraint Violation");
        problemDetails.setType("https://example.com/probs/database");
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setInstance(exception.getClass().getName());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetails> handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setTitle("Business Rule Violation");
        problemDetails.setType("https://example.com/probs/business");
        problemDetails.setInstance(exception.getClass().getName());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ProblemDetails> handleValidationException(ValidationException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setValidationErrors(exception.getValidationErrors());
        problemDetails.setDetail("Multiple validation errors occurred");
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setTitle("Validation Rule Violation");
        problemDetails.setType("https://example.com/probs/validation");
        problemDetails.setInstance(exception.getClass().getName());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetails> handleValidationException(MethodArgumentNotValidException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        Map<String, String> validationErrors = new HashMap<>();
        
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        });
        
        StringBuilder detailBuilder = new StringBuilder();
        validationErrors.forEach((field, message) -> 
            detailBuilder.append(field).append(": ").append(message).append("\n")
        );
        
        problemDetails.setValidationErrors(validationErrors);
        problemDetails.setDetail(detailBuilder.toString().trim());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setTitle("Validation Problem");
        problemDetails.setType("https://example.com/probs/validation");
        problemDetails.setInstance(exception.getClass().getName());
        
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }
} 