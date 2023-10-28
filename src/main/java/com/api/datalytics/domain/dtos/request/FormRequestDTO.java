package com.api.datalytics.domain.dtos.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class FormRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
}
