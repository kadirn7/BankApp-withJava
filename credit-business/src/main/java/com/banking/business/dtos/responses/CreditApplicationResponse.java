package com.banking.business.dtos.responses;

import com.banking.entities.enums.CreditApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreditApplicationResponse {
    
    private Long id;
    private Long creditId;
    private Long customerId;
    private BigDecimal amount;
    private Integer term; // Ay cinsinden
    private BigDecimal monthlyPayment;
    private BigDecimal totalPayment;
    private CreditApplicationStatus status;
    private LocalDateTime applicationDate;
    private LocalDateTime responseDate;
    private String rejectionReason;
}