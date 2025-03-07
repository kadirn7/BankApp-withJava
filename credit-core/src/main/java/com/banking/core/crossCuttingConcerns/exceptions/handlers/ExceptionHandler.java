package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;
import org.springframework.http.ResponseEntity;


public interface ExceptionHandler {
    ResponseEntity<ProblemDetails> handleException(Exception exception);
} 