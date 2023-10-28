package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.ContactResponseDTO;
import com.api.datalytics.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts") // Define o path base para todos os endpoints relacionados as mensagens
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<ContactResponseDTO> findAll() {
        return contactService.findAll();
    }
}
