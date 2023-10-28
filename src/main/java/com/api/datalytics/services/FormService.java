package com.api.datalytics.services;

import com.api.datalytics.domain.dtos.response.FormResponseDTO;
import com.api.datalytics.domain.entities.Form;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public List<FormResponseDTO> findAll(){
        List<Form> forms = formRepository.findAll();
        return mapStructMapper.toFormResponseDTOList(forms);
    }


}
