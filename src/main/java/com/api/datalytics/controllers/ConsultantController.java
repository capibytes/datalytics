package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.ConsultantResponseDTO;
import com.api.datalytics.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consultants") // Define o path base para todos os endpoints relacionados a consultores
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @GetMapping
    public List<ConsultantResponseDTO> getAllConsultants() {
        return consultantService.findAll();
    }
}
