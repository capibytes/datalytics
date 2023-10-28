package com.api.datalytics.services;

import com.api.datalytics.domain.dtos.request.ConsultantRequestDTO;
import com.api.datalytics.domain.dtos.response.ConsultantResponseDTO;
import com.api.datalytics.domain.entities.Consultant;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.repositories.ConsultantRepository;
import com.api.datalytics.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ConsultantRequestDTO save(ConsultantRequestDTO consultantRequest){
        Consultant consultant = mapStructMapper.consultantToConsultantRequestDTO(consultantRequest);
        return mapStructMapper.consultantRequestDTOToConsultant(consultantRepository.save(consultant));
    }

    public void delete(ConsultantRequestDTO consultantRequest){
        consultantRepository.delete(mapStructMapper.consultantToConsultantRequestDTO(consultantRequest));
    }

    public Optional<ConsultantResponseDTO> findById(Long id){
        Consultant consultant = consultantRepository.findById(id).orElseThrow(() ->  new ObjectNotFoundException("Consultor não localizado" + id));
        return Optional.ofNullable(mapStructMapper.consultantResponseDTOToConsultant(consultant));
    }
}
