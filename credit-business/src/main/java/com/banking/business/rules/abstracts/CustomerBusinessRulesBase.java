package com.banking.business.rules.abstracts;

public interface CustomerBusinessRulesBase {
    void checkIfEmailExists(String email);
    void checkIfPhoneNumberExists(String phoneNumber);
} 