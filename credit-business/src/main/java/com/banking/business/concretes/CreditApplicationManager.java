package com.banking.business.concretes;

import com.banking.business.abstracts.CreditApplicationService;
import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.business.dtos.responses.PagedResponse;
import com.banking.business.mappings.CreditApplicationMapper;
import com.banking.business.rules.CreditApplicationBusinessRules;
import com.banking.entities.concretes.CreditApplication;
import com.banking.entities.concretes.Credit;
import com.banking.entities.concretes.IndividualCustomer;
import com.banking.entities.enums.CreditApplicationStatus;
import com.banking.repositories.abstracts.CreditApplicationRepository;
import com.banking.repositories.abstracts.CreditRepository;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CreditApplicationManager implements CreditApplicationService {
    private final CreditApplicationRepository creditApplicationRepository;
    private final CreditRepository creditRepository;
    private final IndividualCustomerRepository customerRepository;
    private final CreditApplicationMapper creditApplicationMapper;
    private final CreditApplicationBusinessRules businessRules;

    @Override
    public CreditApplicationResponse add(CreateCreditApplicationRequest request) {
        Credit credit = creditRepository.findById(request.getCreditId())
            .orElseThrow(() -> new RuntimeException("Credit not found"));
        IndividualCustomer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Validate credit application
        businessRules.validateCreditApplication(credit, customer, request.getAmount(), request.getTerm());

        // Create credit application
        CreditApplication application = creditApplicationMapper.toEntity(request);
        application.setCredit(credit);
        application.setCustomer(customer);

        // Calculate payments
        BigDecimal monthlyPayment = businessRules.calculateMonthlyPayment(
            request.getAmount(), credit.getInterestRate(), request.getTerm());
        BigDecimal totalPayment = businessRules.calculateTotalPayment(monthlyPayment, request.getTerm());

        application.setMonthlyPayment(monthlyPayment);
        application.setTotalPayment(totalPayment);
        application.setStatus(CreditApplicationStatus.PENDING);

        application = creditApplicationRepository.save(application);
        return creditApplicationMapper.toResponse(application);
    }

    @Override
    public PagedResponse<CreditApplicationResponse> getAllApplications(Pageable pageable) {
        var page = creditApplicationRepository.findAll(pageable)
            .map(creditApplicationMapper::toResponse);
        return PagedResponse.fromPage(page);
    }

    @Override
    public CreditApplicationResponse cancel(Long id) {
        CreditApplication application = creditApplicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Credit application not found"));
        
        if (application.getStatus() != CreditApplicationStatus.PENDING) {
            throw new RuntimeException("Only pending applications can be cancelled");
        }

        application.setStatus(CreditApplicationStatus.REJECTED);
        application.setRejectionReason("Application cancelled by customer");
        application = creditApplicationRepository.save(application);
        
        return creditApplicationMapper.toResponse(application);
    }
}