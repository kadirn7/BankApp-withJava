package com.banking.webapi.controllers;

import com.banking.business.abstracts.CreditTypeService;
import com.banking.business.dtos.responses.CreditTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credit-types")
@AllArgsConstructor
public class CreditTypeController {
    private final CreditTypeService creditTypeService;

    @Operation(summary = "Get all credit types")
    @GetMapping
    public ResponseEntity<List<CreditTypeResponse>> getAll() {
        return ResponseEntity.ok(creditTypeService.getAll());
    }

    @Operation(summary = "Get credit type by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Credit type found"),
        @ApiResponse(responseCode = "404", description = "Credit type not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CreditTypeResponse> getById(@PathVariable Long id) {
        if (!creditTypeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(creditTypeService.getById(id));
    }

    @Operation(summary = "Get credit type by name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Credit type found"),
        @ApiResponse(responseCode = "404", description = "Credit type not found")
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<CreditTypeResponse> getByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(creditTypeService.getByName(name));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 