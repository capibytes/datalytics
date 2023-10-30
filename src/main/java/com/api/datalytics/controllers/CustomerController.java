package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.request.CustomerRequestDTO;
import com.api.datalytics.domain.dtos.response.CustomerResponseDTO;
import com.api.datalytics.domain.entities.Customer;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers") // Define o path base para todos os endpoints relacionados as mensagens
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    MapStructMapper mapStructMapper;

    @GetMapping
    public List<CustomerResponseDTO> findAll() {
        return customerService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid @RequestBody CustomerRequestDTO customerRequestDTO){
        return ResponseEntity.ok(customerService.save(customerRequestDTO));
    }

}