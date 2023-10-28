package com.api.datalytics.domain.mappers;

import com.api.datalytics.domain.dtos.ConsultantResponseDTO;
import com.api.datalytics.domain.entities.Consultant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    ConsultantResponseDTO toConsultantResponseDTO(Consultant consultant);
    List<ConsultantResponseDTO> toConsultantResponseDTOList(List<Consultant> consultants);

}
