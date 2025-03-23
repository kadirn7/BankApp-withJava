package com.banking.business.rules;

import com.banking.entities.concretes.Credit;
import com.banking.entities.concretes.IndividualCustomer;
import com.banking.entities.enums.CreditType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CreditApplicationBusinessRules {
    
    public void validateCreditApplication(Credit credit, IndividualCustomer customer, BigDecimal amount, Integer term) {
        validateCreditType(credit, customer);
        validateAmount(credit, amount);
        validateTerm(credit, term);
    }

    private void validateCreditType(Credit credit, IndividualCustomer customer) {
        if (credit.getCreditType() == CreditType.CORPORATE) {
            throw new RuntimeException("Individual customers cannot apply for corporate credits");
        }
    }

    private void validateAmount(Credit credit, BigDecimal amount) {
        if (amount.compareTo(credit.getMinimumAmount()) < 0) {
            throw new RuntimeException("Amount is below minimum credit amount");
        }
        if (amount.compareTo(credit.getMaximumAmount()) > 0) {
            throw new RuntimeException("Amount exceeds maximum credit amount");
        }
    }

    private void validateTerm(Credit credit, Integer term) {
        if (term < credit.getMinimumTerm()) {
            throw new RuntimeException("Term is below minimum credit term");
        }
        if (term > credit.getMaximumTerm()) {
            throw new RuntimeException("Term exceeds maximum credit term");
        }
    }

    public BigDecimal calculateMonthlyPayment(BigDecimal amount, BigDecimal interestRate, Integer term) {
        // Monthly interest rate
        BigDecimal monthlyRate = interestRate.divide(new BigDecimal("12"), 8, RoundingMode.HALF_UP);
        
        // (1 + r)^n
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal power = onePlusRate.pow(term);
        
        // P * r * (1 + r)^n / ((1 + r)^n - 1)
        BigDecimal numerator = amount.multiply(monthlyRate).multiply(power);
        BigDecimal denominator = power.subtract(BigDecimal.ONE);
        
        return numerator.divide(denominator, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateTotalPayment(BigDecimal monthlyPayment, Integer term) {
        return monthlyPayment.multiply(new BigDecimal(term));
    }
}
