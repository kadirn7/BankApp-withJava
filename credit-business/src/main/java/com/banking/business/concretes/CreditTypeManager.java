package com.banking.business.concretes;

import com.banking.business.abstracts.CreditTypeService;
import com.banking.business.dtos.responses.CreditTypeResponse;
import com.banking.entities.enums.CreditType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditTypeManager implements CreditTypeService {

    @Override
    public List<CreditTypeResponse> getAll() {
        return List.of(CreditType.values()).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CreditTypeResponse getById(Long id) {
        if (id < 0 || id >= CreditType.values().length) {
            throw new RuntimeException("Invalid credit type ID");
        }
        return mapToResponse(CreditType.values()[id.intValue()]);
    }

    @Override
    public CreditTypeResponse getByName(String name) {
        try {
            return mapToResponse(CreditType.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid credit type name: " + name);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return id >= 0 && id < CreditType.values().length;
    }

    private CreditTypeResponse mapToResponse(CreditType creditType) {
        CreditTypeResponse response = new CreditTypeResponse();
        response.setId((long) creditType.ordinal());
        response.setName(creditType.name());
        response.setDescription(getDescription(creditType));
        return response;
    }

    private String getDescription(CreditType creditType) {
        return switch (creditType) {
            case INDIVIDUAL -> "Bireysel Kredi";
            case CORPORATE -> "Kurumsal Kredi";
            case BOTH -> "Her İkisi İçin Geçerli";
        };
    }
} 