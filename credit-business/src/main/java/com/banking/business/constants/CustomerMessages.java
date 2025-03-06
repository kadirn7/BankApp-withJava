package com.banking.business.constants;

public class CustomerMessages {
    // Customer
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists: %s";
    public static final String PHONE_NUMBER_ALREADY_EXISTS = "Phone number already exists: %s";
    
    // Individual Customer
    public static final String NATIONAL_IDENTITY_ALREADY_EXISTS = "National identity already exists: %s";
    public static final String INDIVIDUAL_CUSTOMER_NOT_FOUND = "Individual customer not found with national identity: %s";
    
    // Corporate Customer
    public static final String TAX_NUMBER_ALREADY_EXISTS = "Tax number already exists: %s";
    public static final String CORPORATE_CUSTOMER_NOT_FOUND = "Corporate customer not found with tax number: %s";
} 
