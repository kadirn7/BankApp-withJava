package com.banking.business.rules;

import com.banking.business.constants.CustomerMessages;
import com.banking.business.rules.abstracts.CustomerBusinessRulesBase;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules implements CustomerBusinessRulesBase {
    private final IndividualCustomerRepository repository;

    public void checkIfEmailExists(String email) {
        if (repository.existsByEmail(email)){
            throw new BusinessException(String.format(CustomerMessages.EMAIL_ALREADY_EXISTS, email));
        }
    }

    public void checkIfPhoneNumberExists(String phoneNumber) {
        if (repository.existsByPhoneNumber(phoneNumber))
            throw new BusinessException(String.format(CustomerMessages.PHONE_NUMBER_ALREADY_EXISTS, phoneNumber));
    }

    public void checkIfNationalIdentityExists(String nationalIdentity) {
        if (repository.existsByNationalIdentity(nationalIdentity))
            throw new BusinessException(String.format(CustomerMessages.NATIONAL_IDENTITY_ALREADY_EXISTS, nationalIdentity));
    }
}