package com.banking.entities.concretes;


import com.banking.core.entities.BaseEntity;
import com.banking.entities.enums.CreditApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "credit_applications")
public class CreditApplication extends BaseEntity<Long> {
    
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private IndividualCustomer customer; // Bireysel müşteri
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @Column(name = "term")
    private Integer term; // Ay cinsinden
    
    @Column(name = "monthly_payment")
    private BigDecimal monthlyPayment;
    
    @Column(name = "total_payment")
    private BigDecimal totalPayment;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CreditApplicationStatus status;
    
    @Column(name = "application_date")
    private LocalDateTime applicationDate;
    
    @Column(name = "response_date")
    private LocalDateTime responseDate;
    
    @Column(name = "rejection_reason")
    private String rejectionReason;
}