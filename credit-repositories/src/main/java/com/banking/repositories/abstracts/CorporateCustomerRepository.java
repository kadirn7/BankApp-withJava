package com.banking.repositories.abstracts;

import com.banking.entities.concretes.CorporateCustomer;

public interface CorporateCustomerRepository extends CustomerRepository<CorporateCustomer> {
    boolean existsByTaxNumber(String taxNumber);
    CorporateCustomer findByTaxNumber(String taxNumber);
    CorporateCustomer findByTradeRegisterNumber(String tradeRegisterNumber);
} 