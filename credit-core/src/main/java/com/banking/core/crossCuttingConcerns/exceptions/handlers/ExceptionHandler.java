package com.banking.core.crossCuttingConcerns.exceptions.handlers;

import com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;

public interface ExceptionHandler {
    ProblemDetails handleException(Exception exception);
} 