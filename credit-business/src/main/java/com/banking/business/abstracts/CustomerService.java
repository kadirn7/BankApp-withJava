package com.banking.business.abstracts;

import com.banking.business.dtos.responses.CustomerResponse;
import java.util.List;

public interface CustomerService<T extends CustomerResponse> {
    List<T> getAll();
    void delete(Long id);
    T getByCustomerNumber(String customerNumber);
} 