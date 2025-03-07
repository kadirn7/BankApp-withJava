package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.PagedResponse;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface IndividualCustomerService extends CustomerService<IndividualCustomerResponse> {
    IndividualCustomerResponse add(CreateIndividualCustomerRequest request);
    List<IndividualCustomerResponse> getAllIndividuals();
    PagedResponse<IndividualCustomerResponse> getAllIndividualsPaged(Pageable pageable);
    IndividualCustomerResponse getByNationalIdentity(String nationalIdentity);
    IndividualCustomerResponse getById(Long id);
    void delete(Long id);
} 