package com.banking.business.dtos.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class CorporateCustomerResponse extends CustomerResponse {
    private String taxNumber;
    private String companyName;
    private String tradeRegisterNumber;
    private String contactPerson;
} 