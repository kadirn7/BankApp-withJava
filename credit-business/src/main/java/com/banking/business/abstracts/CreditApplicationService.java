package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import org.springframework.data.domain.Pageable;
import com.banking.business.dtos.responses.PagedResponse;

public interface CreditApplicationService {
    CreditApplicationResponse add(CreateCreditApplicationRequest request);
    PagedResponse<CreditApplicationResponse> getAllApplications(Pageable pageable);
    CreditApplicationResponse cancel(Long id);

}