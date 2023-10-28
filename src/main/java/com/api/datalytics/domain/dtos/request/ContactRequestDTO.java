package com.api.datalytics.domain.dtos.request;

import com.api.datalytics.domain.entities.Consultant;
import com.api.datalytics.domain.entities.Customer;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ContactRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private LocalDate dataContact;
    private Consultant consultant;
    private Customer customer;
}
