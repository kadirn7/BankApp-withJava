package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.mappings.abstracts.CustomerMapperBase;
import com.banking.entities.concretes.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IndividualCustomerMapper extends CustomerMapperBase<IndividualCustomerResponse, IndividualCustomer> {
    @Override
    
    IndividualCustomerResponse toResponse(IndividualCustomer entity);
    
    IndividualCustomer toEntity(CreateIndividualCustomerRequest request);
} 