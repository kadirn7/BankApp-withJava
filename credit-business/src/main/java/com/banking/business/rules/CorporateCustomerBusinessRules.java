package com.banking.business.rules;

import com.banking.business.constants.CustomerMessages;
import com.banking.business.rules.abstracts.CustomerBusinessRulesBase;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules implements CustomerBusinessRulesBase {
    private final CorporateCustomerRepository repository;

    @Override
    public void checkIfEmailExists(String email) {
        if (repository.existsByEmail(email)) {
            throw new BusinessException(
                String.format(CustomerMessages.EMAIL_ALREADY_EXISTS, email)
            );
        }
    }

    @Override
    public void checkIfPhoneNumberExists(String phoneNumber) {
        if (repository.existsByPhoneNumber(phoneNumber)) {
            throw new BusinessException(
                String.format(CustomerMessages.PHONE_NUMBER_ALREADY_EXISTS, phoneNumber)
            );
        }
    }

    public void checkIfTaxNumberExists(String taxNumber) {
        if (repository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(
                String.format(CustomerMessages.TAX_NUMBER_ALREADY_EXISTS, taxNumber)
            );
        }
    }
} 