package com.banking.entities.concretes;

import com.banking.entities.abstracts.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "corporate_customers")
public class CorporateCustomer extends Customer {
    private String taxNumber;
    private String companyName;
    private String tradeRegisterNumber;
} 