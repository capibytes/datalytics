package com.api.datalytics.services;

import com.api.datalytics.domain.dtos.ConsultantResponseDTO;
import com.api.datalytics.domain.entities.Consultant;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.repositories.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {

    @Autowired
    ConsultantRepository consultantRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public List<ConsultantResponseDTO> findAll(){
        List<Consultant> consultants = consultantRepository.findAll();
        return mapStructMapper.toConsultantResponseDTOList(consultants);
    }

}
