package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.business.mappings.abstracts.CustomerMapperBase;
import com.banking.entities.concretes.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CorporateCustomerMapper extends CustomerMapperBase<CorporateCustomerResponse, CorporateCustomer> {
    @Override
    
    CorporateCustomerResponse toResponse(CorporateCustomer entity);
    
    CorporateCustomer toEntity(CreateCorporateCustomerRequest request);
} 