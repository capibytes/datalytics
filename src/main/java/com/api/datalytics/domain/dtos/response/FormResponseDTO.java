package com.api.datalytics.domain.dtos.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class FormResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
}
