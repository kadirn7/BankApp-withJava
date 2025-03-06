package com.banking.core.crossCuttingConcerns.exceptions.types;

import java.util.Map;

public class ValidationException extends RuntimeException {
    private final Map<String, String> validationErrors;

    public ValidationException(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }
} 