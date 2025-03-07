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
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerNumber", source = "customerNumber")
    @Mapping(target = "taxNumber", source = "taxNumber")
    @Mapping(target = "companyName", source = "companyName")
    @Mapping(target = "tradeRegisterNumber", source = "tradeRegisterNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "address", source = "address")
    CorporateCustomerResponse toResponse(CorporateCustomer entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    CorporateCustomer toEntity(CreateCorporateCustomerRequest request);
} 