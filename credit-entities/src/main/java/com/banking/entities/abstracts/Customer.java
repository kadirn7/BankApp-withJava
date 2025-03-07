package com.banking.entities.abstracts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers", schema = "credit_system")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "customer_number", unique = true)
    private String customerNumber;
    private String email;
    private String phoneNumber;
    private String address;
} 
