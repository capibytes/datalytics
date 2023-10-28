package com.api.datalytics.services;

import com.api.datalytics.domain.dtos.ContactResponseDTO;
import com.api.datalytics.domain.entities.Contact;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public List<ContactResponseDTO> findAll(){
        List<Contact> contacts = contactRepository.findAll();
        return mapStructMapper.toContactResponseDTOList(contacts);
    }
}
