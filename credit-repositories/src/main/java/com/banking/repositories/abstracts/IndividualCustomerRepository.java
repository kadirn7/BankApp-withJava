package com.banking.repositories.abstracts;

import com.banking.entities.concretes.IndividualCustomer;

public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer> {
    boolean existsByNationalIdentity(String nationalIdentity);
    IndividualCustomer findByNationalIdentity(String nationalIdentity);
    IndividualCustomer findByPhoneNumber(String phoneNumber);
    IndividualCustomer findByCustomerNumber(String customerNumber);
} 