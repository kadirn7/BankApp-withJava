package com.banking.business.concretes;

import com.banking.business.abstracts.IndividualCustomerCreditTypeService;
import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCustomerCreditTypeResponse;
import com.banking.entities.concretes.IndividualCustomer;
import com.banking.entities.enums.CreditType;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualCustomerCreditTypeManager implements IndividualCustomerCreditTypeService {
    private final IndividualCustomerRepository customerRepository;

    @Override
    public IndividualCustomerCreditTypeResponse create(CreateIndividualCreditTypeRequest request) {
        IndividualCustomer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToResponse(customer);
    }

    @Override
    public List<IndividualCustomerCreditTypeResponse> getAllByCustomerId(Long customerId) {
        return customerRepository.findAll().stream()
            .filter(customer -> customer.getId().equals(customerId))
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public IndividualCustomerCreditTypeResponse getById(Long id) {
        IndividualCustomer customer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToResponse(customer);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        if (!existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    private IndividualCustomerCreditTypeResponse mapToResponse(IndividualCustomer customer) {
        IndividualCustomerCreditTypeResponse response = new IndividualCustomerCreditTypeResponse();
        response.setId(customer.getId());
        response.setCustomerId(customer.getId());
        response.setCustomerNumber(customer.getCustomerNumber());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setNationalIdentity(customer.getNationalIdentity());
        response.setName(CreditType.INDIVIDUAL.name());
        response.setDescription("Bireysel Kredi");
        return response;
    }
} 