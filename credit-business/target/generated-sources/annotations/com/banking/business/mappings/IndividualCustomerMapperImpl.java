package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.concretes.IndividualCustomer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-06T16:56:35+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class IndividualCustomerMapperImpl implements IndividualCustomerMapper {

    @Override
    public IndividualCustomerResponse toResponse(IndividualCustomer entity) {
        if ( entity == null ) {
            return null;
        }

        IndividualCustomerResponse individualCustomerResponse = new IndividualCustomerResponse();

        individualCustomerResponse.setAddress( entity.getAddress() );
        individualCustomerResponse.setEmail( entity.getEmail() );
        individualCustomerResponse.setId( entity.getId() );
        individualCustomerResponse.setPhoneNumber( entity.getPhoneNumber() );
        individualCustomerResponse.setFirstName( entity.getFirstName() );
        individualCustomerResponse.setLastName( entity.getLastName() );
        individualCustomerResponse.setNationalIdentity( entity.getNationalIdentity() );

        return individualCustomerResponse;
    }

    @Override
    public IndividualCustomer toEntity(CreateIndividualCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setAddress( request.getAddress() );
        individualCustomer.setEmail( request.getEmail() );
        individualCustomer.setPhoneNumber( request.getPhoneNumber() );
        individualCustomer.setFirstName( request.getFirstName() );
        individualCustomer.setLastName( request.getLastName() );
        individualCustomer.setNationalIdentity( request.getNationalIdentity() );

        return individualCustomer;
    }
}
