package com.api.datalytics.domain.dtos;

import com.api.datalytics.domain.entities.Contact;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ConsultantRequestDTO {

    private String name;
    private String cpf;
    private String email;
    private Integer profile;
    private List<Contact> contacts = new ArrayList<>();
    private String specialization;
    private String about;
    private Set<String> links = new HashSet<>();
    
    
}
