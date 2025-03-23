package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCustomerCreditTypeService;
import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCustomerCreditTypeResponse;
import com.banking.entities.concretes.CorporateCustomer;
import com.banking.entities.enums.CreditType;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CorporateCustomerCreditTypeManager implements CorporateCustomerCreditTypeService {
    private final CorporateCustomerRepository customerRepository;

    @Override
    public CorporateCustomerCreditTypeResponse create(CreateCorporateCreditTypeRequest request) {
        CorporateCustomer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToResponse(customer);
    }

    @Override
    public List<CorporateCustomerCreditTypeResponse> getAllByCustomerId(Long customerId) {
        return customerRepository.findAll().stream()
            .filter(customer -> customer.getId().equals(customerId))
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public CorporateCustomerCreditTypeResponse getById(Long id) {
        CorporateCustomer customer = customerRepository.findById(id)
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

    private CorporateCustomerCreditTypeResponse mapToResponse(CorporateCustomer customer) {
        CorporateCustomerCreditTypeResponse response = new CorporateCustomerCreditTypeResponse();
        response.setId(customer.getId());
        response.setCustomerId(customer.getId());
        response.setCustomerNumber(customer.getCustomerNumber());
        response.setCompanyName(customer.getCompanyName());
        response.setTaxNumber(customer.getTaxNumber());
        response.setTradeRegisterNumber(customer.getTradeRegisterNumber());
        response.setContactPerson(customer.getContactPerson());
        response.setName(CreditType.CORPORATE.name());
        response.setDescription("Kurumsal Kredi");
        return response;
    }
}