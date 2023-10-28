package com.api.datalytics.domain.mappers;

import com.api.datalytics.domain.dtos.request.ConsultantRequestDTO;
import com.api.datalytics.domain.dtos.request.ContactRequestDTO;
import com.api.datalytics.domain.dtos.request.CustomerRequestDTO;
import com.api.datalytics.domain.dtos.request.FormRequestDTO;
import com.api.datalytics.domain.dtos.response.ConsultantResponseDTO;
import com.api.datalytics.domain.dtos.response.ContactResponseDTO;
import com.api.datalytics.domain.dtos.response.CustomerResponseDTO;
import com.api.datalytics.domain.dtos.response.FormResponseDTO;
import com.api.datalytics.domain.entities.Consultant;
import com.api.datalytics.domain.entities.Contact;
import com.api.datalytics.domain.entities.Customer;
import com.api.datalytics.domain.entities.Form;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "Spring")
public interface MapStructMapper {
    // Instancia para utlizar o MapStruct caso queira
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);


    List<ConsultantResponseDTO> toConsultantResponseDTOList(List<Consultant> consultant);

    Consultant consultantToConsultantRequestDTO(ConsultantRequestDTO contactRequestDTO);

    ConsultantRequestDTO consultantRequestDTOToConsultant(Consultant consultant);

    Optional<ConsultantResponseDTO> consultantResponseDTOToConsultant(Optional<Consultant> consultant);

    List<CustomerResponseDTO> toCustomerResponseDTOList(List<Customer> customer);

    Customer customerToCustomerResponseDTO(CustomerResponseDTO customerResponseDTO);

    CustomerRequestDTO customerRequestDTOToCustomer(Customer customer);


    List<ContactResponseDTO> toContactResponseDTOList(List<Contact> contact);

    Contact contactToContactResponseDTO(ContactResponseDTO contactResponseDTO);

    ContactRequestDTO contactRequestDTOToContact(Contact contact);

    Form formToFormResponseDTO(FormResponseDTO formResponseDTO);

    FormRequestDTO formRequestDTOToForm(Form form);

    List<FormResponseDTO> toFormResponseDTOList(List<Form> form);

}
