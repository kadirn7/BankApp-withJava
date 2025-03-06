package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import java.util.List;

public interface CorporateCustomerService extends CustomerService<CorporateCustomerResponse> {
    CorporateCustomerResponse add(CreateCorporateCustomerRequest request);
    List<CorporateCustomerResponse> getAllCorporates();
    CorporateCustomerResponse getByTaxNumber(String taxNumber);
} 