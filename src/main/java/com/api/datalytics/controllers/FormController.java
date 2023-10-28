package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.response.FormResponseDTO;
import com.api.datalytics.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/forms") // Define o path base para todos os endpoints relacionados aos formularios
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping
    public List<FormResponseDTO> findAll() {
        return formService.findAll();
    }
}
