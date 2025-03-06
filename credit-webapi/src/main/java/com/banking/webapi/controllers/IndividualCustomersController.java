package com.banking.webapi.controllers;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "Individual Customer API")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @Operation(summary = "Create a new individual customer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Customer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        return individualCustomerService.add(request);
    }

    @GetMapping
    @Operation(summary = "Get all individual customers")
    public List<IndividualCustomerResponse> getAll() {
        return individualCustomerService.getAllIndividuals();
    }

    @GetMapping("/national-identity/{nationalIdentity}")
    @Operation(summary = "Get individual customer by national identity")
    public IndividualCustomerResponse getByNationalIdentity(@PathVariable String nationalIdentity) {
        return individualCustomerService.getByNationalIdentity(nationalIdentity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete individual customer by ID")
    public void delete(@PathVariable Long id) {
        individualCustomerService.delete(id);
    }
} 