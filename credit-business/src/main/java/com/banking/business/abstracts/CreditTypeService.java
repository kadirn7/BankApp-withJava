package com.banking.business.abstracts;

import com.banking.business.dtos.responses.CreditTypeResponse;


import java.util.List;

public interface CreditTypeService {
    List<CreditTypeResponse> getAll();
    CreditTypeResponse getById(Long id);
    CreditTypeResponse getByName(String name);
    boolean existsById(Long id);
} 