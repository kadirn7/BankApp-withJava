package com.banking.webapi.controllers;

import com.banking.business.abstracts.CreditApplicationService;
import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.business.dtos.responses.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-applications")
@AllArgsConstructor
public class CreditApplicationController {
    private final CreditApplicationService creditApplicationService;

    @Operation(summary = "Create a new credit application")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Application created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<CreditApplicationResponse> add(@Valid @RequestBody CreateCreditApplicationRequest request) {
        CreditApplicationResponse response = creditApplicationService.add(request);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "Get all credit applications with pagination")
    @GetMapping("/paged")
    public ResponseEntity<PagedResponse<CreditApplicationResponse>> getAllPaged(Pageable pageable) {
        return ResponseEntity.ok(creditApplicationService.getAllApplications(pageable));
    }
}