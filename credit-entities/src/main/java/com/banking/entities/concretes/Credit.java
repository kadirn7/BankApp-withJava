package com.banking.entities.concretes;


import com.banking.core.entities.BaseEntity;
import com.banking.entities.enums.CreditType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "credits")
public class Credit extends BaseEntity<Long> {
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "credit_type")
    private CreditType creditType;
    
    @Column(name = "interest_rate")
    private BigDecimal interestRate;
    
    @Column(name = "minimum_amount")
    private BigDecimal minimumAmount;
    
    @Column(name = "maximum_amount")
    private BigDecimal maximumAmount;
    
    @Column(name = "minimum_term")
    private Integer minimumTerm; // Ay cinsinden
    
    @Column(name = "maximum_term")
    private Integer maximumTerm; // Ay cinsinden
}