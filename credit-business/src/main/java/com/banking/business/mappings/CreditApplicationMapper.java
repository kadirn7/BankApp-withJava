package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.entities.concretes.CreditApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "credit.id", source = "creditId")
    @Mapping(target = "customer.id", source = "customerId")
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "applicationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "term", source = "term")
    @Mapping(target = "monthlyPayment", ignore = true)
    @Mapping(target = "totalPayment", ignore = true)
    @Mapping(target = "responseDate", ignore = true)
    @Mapping(target = "rejectionReason", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    CreditApplication toEntity(CreateCreditApplicationRequest request);

    @Mapping(target = "creditId", source = "credit.id")
    @Mapping(target = "customerId", source = "customer.id")
    CreditApplicationResponse toResponse(CreditApplication entity);
} 