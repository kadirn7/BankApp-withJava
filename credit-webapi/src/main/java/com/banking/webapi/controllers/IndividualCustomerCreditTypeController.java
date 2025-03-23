package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCustomerCreditTypeService;
import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCustomerCreditTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-credit-types")
@AllArgsConstructor
public class IndividualCustomerCreditTypeController {
    private final IndividualCustomerCreditTypeService creditTypeService;

    @Operation(summary = "Create a new individual credit type")
    @PostMapping
    public ResponseEntity<IndividualCustomerCreditTypeResponse> create(@Valid @RequestBody CreateIndividualCreditTypeRequest request) {
        return ResponseEntity.ok(creditTypeService.create(request));
    }

    @Operation(summary = "Get all credit types for a customer")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<IndividualCustomerCreditTypeResponse>> getAllByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(creditTypeService.getAllByCustomerId(customerId));
    }

    @Operation(summary = "Get credit type by ID")
    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerCreditTypeResponse> getById(@PathVariable Long id) {
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