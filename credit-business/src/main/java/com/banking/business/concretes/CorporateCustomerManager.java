package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCustomerService;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.business.mappings.CorporateCustomerMapper;
import com.banking.business.rules.CorporateCustomerBusinessRules;
import com.banking.entities.concretes.CorporateCustomer;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository repository;
    private final CorporateCustomerMapper mapper;
    private final CorporateCustomerBusinessRules rules;

    @Override
    public CorporateCustomerResponse add(CreateCorporateCustomerRequest request) {
        rules.checkIfEmailExists(request.getEmail());
        rules.checkIfPhoneNumberExists(request.getPhoneNumber());
        rules.checkIfTaxNumberExists(request.getTaxNumber());

        CorporateCustomer customer = mapper.toEntity(request);
        customer = repository.save(customer);
        return mapper.toResponse(customer);
    }

    @Override
    public List<CorporateCustomerResponse> getAllCorporates() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        return mapper.toResponse(repository.findByTaxNumber(taxNumber));
    }

    @Override
    public List<CorporateCustomerResponse> getAll() {
        return getAllCorporates();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CorporateCustomerResponse getByCustomerNumber(String customerNumber) {
        return mapper.toResponse(repository.findByCustomerNumber(customerNumber));
    }
} 