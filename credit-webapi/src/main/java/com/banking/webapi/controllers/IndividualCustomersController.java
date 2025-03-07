package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.PagedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "Individual Customer Management APIs")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @Operation(summary = "Create a new individual customer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Customer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<IndividualCustomerResponse> add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        IndividualCustomerResponse response = individualCustomerService.add(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all individual customers")
    @GetMapping
    public ResponseEntity<List<IndividualCustomerResponse>> getAll() {
        return ResponseEntity.ok(individualCustomerService.getAllIndividuals());
    }

    @Operation(summary = "Get individual customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(individualCustomerService.getById(id));
    }

    @GetMapping("/national-identity/{nationalIdentity}")
    @Operation(summary = "Get individual customer by national identity")
    public ResponseEntity<IndividualCustomerResponse> getByNationalIdentity(@PathVariable String nationalIdentity) {
        return ResponseEntity.ok(individualCustomerService.getByNationalIdentity(nationalIdentity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete individual customer by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        individualCustomerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all individual customers with pagination")
    @GetMapping("/paged")
    public ResponseEntity<PagedResponse<IndividualCustomerResponse>> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? 
            Sort.Direction.DESC : Sort.Direction.ASC;
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        return ResponseEntity.ok(individualCustomerService.getAllIndividualsPaged(pageable));
    }
} 