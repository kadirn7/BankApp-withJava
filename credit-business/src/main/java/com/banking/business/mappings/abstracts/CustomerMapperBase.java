package com.banking.business.mappings.abstracts;

import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.entities.abstracts.Customer;

public interface CustomerMapperBase<T extends CustomerResponse, E extends Customer> {
    T toResponse(E entity);
} 