package com.banking.business.concretes;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.mappings.IndividualCustomerMapper;
import com.banking.business.rules.IndividualCustomerBusinessRules;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.entities.concretes.IndividualCustomer;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository repository;
    
    private final IndividualCustomerMapper mapper;
    private final IndividualCustomerBusinessRules rules;
    
    @Override
    public IndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        rules.checkIfEmailExists(request.getEmail());
        rules.checkIfPhoneNumberExists(request.getPhoneNumber());
        rules.checkIfNationalIdentityExists(request.getNationalIdentity());

        IndividualCustomer customer = mapper.toEntity(request);
        customer = repository.save(customer);
        return mapper.toResponse(customer);
    }

    @Override
    public List<IndividualCustomerResponse> getAllIndividuals() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public IndividualCustomerResponse getByNationalIdentity(String nationalIdentity) {
        return mapper.toResponse(repository.findByNationalIdentity(nationalIdentity));
    }

    @Override
    public List<IndividualCustomerResponse> getAll() {
        return getAllIndividuals();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public IndividualCustomerResponse getByCustomerNumber(String customerNumber) {
        return mapper.toResponse(repository.findByCustomerNumber(customerNumber));
    }

    @Override
    public IndividualCustomerResponse getById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(()
         -> new BusinessException("Customer not found")));
    }
} 