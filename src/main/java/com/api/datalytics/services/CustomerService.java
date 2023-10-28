package com.api.datalytics.services;

import com.api.datalytics.domain.dtos.response.CustomerResponseDTO;
import com.api.datalytics.domain.entities.Customer;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MapStructMapper mapStructMapper;

    public List<CustomerResponseDTO> findAll(){
        List<Customer> customers = customerRepository.findAll();
        return mapStructMapper.toCustomerResponseDTOList(customers);
    }
    
}
