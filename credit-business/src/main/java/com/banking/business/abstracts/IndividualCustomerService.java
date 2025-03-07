package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import java.util.List;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {
    IndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    List<IndividualCustomerResponse> getAllIndividuals();
    IndividualCustomerResponse getByNationalIdentity(String nationalIdentity);
    IndividualCustomerResponse getById(Long id);
    void delete(Long id);
} 