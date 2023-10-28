package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.response.CustomerResponseDTO;
import com.api.datalytics.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers") // Define o path base para todos os endpoints relacionados as mensagens
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDTO> findAll() {
        return customerService.findAll();
    }
}