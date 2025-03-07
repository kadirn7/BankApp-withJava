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
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerNumber", source = "customerNumber")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "nationalIdentity", source = "nationalIdentity")
    IndividualCustomerResponse toResponse(IndividualCustomer entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    IndividualCustomer toEntity(CreateIndividualCustomerRequest request);
} 