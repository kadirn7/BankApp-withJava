package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCustomerCreditTypeResponse;

import java.util.List;

public interface IndividualCustomerCreditTypeService {
    IndividualCustomerCreditTypeResponse create(CreateIndividualCreditTypeRequest request);
    List<IndividualCustomerCreditTypeResponse> getAllByCustomerId(Long customerId);
    IndividualCustomerCreditTypeResponse getById(Long id);
    boolean existsById(Long id);
    void delete(Long id);
}