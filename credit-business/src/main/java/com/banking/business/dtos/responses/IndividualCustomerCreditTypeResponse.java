package com.banking.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualCustomerCreditTypeResponse {
    private Long id;
    private String name;
    private String description;
    private Long customerId;
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
} 