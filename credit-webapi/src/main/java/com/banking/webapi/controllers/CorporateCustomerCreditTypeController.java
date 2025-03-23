package com.banking.webapi.controllers;

import com.banking.business.abstracts.CorporateCustomerCreditTypeService;
import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCustomerCreditTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporate-credit-types")
@AllArgsConstructor
public class CorporateCustomerCreditTypeController {
    private final CorporateCustomerCreditTypeService creditTypeService;

    @Operation(summary = "Create a new corporate credit type")
    @PostMapping
    public ResponseEntity<CorporateCustomerCreditTypeResponse> create(@Valid @RequestBody CreateCorporateCreditTypeRequest request) {
        return ResponseEntity.ok(creditTypeService.create(request));
    }

    @Operation(summary = "Get all credit types for a customer")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CorporateCustomerCreditTypeResponse>> getAllByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(creditTypeService.getAllByCustomerId(customerId));
    }

    @Operation(summary = "Get credit type by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CorporateCustomerCreditTypeResponse> getById(@PathVariable Long id) {
        if (!creditTypeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(creditTypeService.getById(id));
    }

    @Operation(summary = "Delete credit type")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        creditTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 