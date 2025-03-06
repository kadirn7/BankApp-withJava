package com.banking.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;
public class AuthorizationProblemDetails extends ProblemDetails {
    public AuthorizationProblemDetails() {
        setTitle("Authorization Error");
        setType("https://example.com/probs/authorization");
        setStatus(HttpStatus.UNAUTHORIZED.value());
    }
} 