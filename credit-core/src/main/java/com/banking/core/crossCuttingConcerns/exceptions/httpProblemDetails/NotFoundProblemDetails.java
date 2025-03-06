package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class NotFoundProblemDetails extends ProblemDetails {
    public NotFoundProblemDetails() {
        setTitle("Resource Not Found");
        setType("https://example.com/probs/not-found");
        setStatus(HttpStatus.NOT_FOUND.value());
    }
} 