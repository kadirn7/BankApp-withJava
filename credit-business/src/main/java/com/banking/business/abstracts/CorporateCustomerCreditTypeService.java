package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCustomerCreditTypeResponse;


import java.util.List;

public interface CorporateCustomerCreditTypeService {
    CorporateCustomerCreditTypeResponse create(CreateCorporateCreditTypeRequest request);
    List<CorporateCustomerCreditTypeResponse> getAllByCustomerId(Long customerId);
    CorporateCustomerCreditTypeResponse getById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}