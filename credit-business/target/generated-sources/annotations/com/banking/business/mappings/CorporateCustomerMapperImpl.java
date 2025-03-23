package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.concretes.CorporateCustomer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T15:07:26+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CorporateCustomerMapperImpl implements CorporateCustomerMapper {

    @Override
    public CorporateCustomerResponse toResponse(CorporateCustomer entity) {
        if ( entity == null ) {
            return null;
        }

        CorporateCustomerResponse corporateCustomerResponse = new CorporateCustomerResponse();

        corporateCustomerResponse.setId( entity.getId() );
        corporateCustomerResponse.setCustomerNumber( entity.getCustomerNumber() );
        corporateCustomerResponse.setTaxNumber( entity.getTaxNumber() );
        corporateCustomerResponse.setCompanyName( entity.getCompanyName() );
        corporateCustomerResponse.setTradeRegisterNumber( entity.getTradeRegisterNumber() );
        corporateCustomerResponse.setEmail( entity.getEmail() );
        corporateCustomerResponse.setPhoneNumber( entity.getPhoneNumber() );
        corporateCustomerResponse.setAddress( entity.getAddress() );
        corporateCustomerResponse.setContactPerson( entity.getContactPerson() );

        return corporateCustomerResponse;
    }

    @Override
    public CorporateCustomer toEntity(CreateCorporateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporateCustomer corporateCustomer = new CorporateCustomer();

        corporateCustomer.setAddress( request.getAddress() );
        corporateCustomer.setEmail( request.getEmail() );
        corporateCustomer.setPhoneNumber( request.getPhoneNumber() );
        corporateCustomer.setCompanyName( request.getCompanyName() );
        corporateCustomer.setContactPerson( request.getContactPerson() );
        corporateCustomer.setTaxNumber( request.getTaxNumber() );
        corporateCustomer.setTradeRegisterNumber( request.getTradeRegisterNumber() );

        return corporateCustomer;
    }
}
