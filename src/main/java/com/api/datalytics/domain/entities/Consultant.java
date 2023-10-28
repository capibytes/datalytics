package com.api.datalytics.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Consultant extends Person {

    @JsonIgnore
    @OneToMany(mappedBy = "consultant")
    private List<Contact> contacts = new ArrayList<>();

    private String specialization;
    private String about;

    private Set<String> links = new HashSet<>();
}
