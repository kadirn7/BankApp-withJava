package com.banking.entities.concretes;

import com.banking.entities.abstracts.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "individual_customers")
public class IndividualCustomer extends Customer {
    private String nationalIdentity;
    private String firstName;
    private String lastName;
} 