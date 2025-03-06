package com.banking.repositories.abstracts;

import com.banking.entities.abstracts.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    T findByCustomerNumber(String customerNumber);
} 