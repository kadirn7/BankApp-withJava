package com.banking.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateCustomerCreditTypeResponse {
    private Long id;
    private String name;
    private String description;
    private Long customerId;
    private String customerNumber;
    private String companyName;
    private String taxNumber;
    private String tradeRegisterNumber;
    private String contactPerson;
} 