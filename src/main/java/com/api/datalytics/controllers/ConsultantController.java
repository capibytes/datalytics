package com.api.datalytics.controllers;

import com.api.datalytics.domain.dtos.request.ConsultantRequestDTO;
import com.api.datalytics.domain.dtos.request.CustomerRequestDTO;
import com.api.datalytics.domain.dtos.response.ConsultantResponseDTO;
import com.api.datalytics.domain.mappers.MapStructMapper;
import com.api.datalytics.services.ConsultantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consultants") // Define o path base para todos os endpoints relacionados a consultores
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    MapStructMapper mapStructMapper;

    @GetMapping
    public List<ConsultantResponseDTO> getAllConsultants() {
        return consultantService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantResponseDTO> findById(@PathVariable(value = "id") Long id){
        Optional<ConsultantResponseDTO> consultantOptional = consultantService.findById(id);
        return consultantOptional.<ResponseEntity<ConsultantResponseDTO>>map(consultant -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(consultant))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id){
        Optional<ConsultantResponseDTO> consultantOptional = consultantService.findById(id);
        if (consultantOptional.isPresent()) {
            consultantService.delete(mapStructMapper.consultantToConsultantResponseDTO(consultantOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body("Consultor " + id + " excluído com sucesso!");
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid @RequestBody ConsultantRequestDTO consultantRequestDTO){
        return ResponseEntity.ok(consultantService.save(consultantRequestDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ConsultantRequestDTO consultantRequestDTO){
        Optional<ConsultantResponseDTO> consultantOptional = consultantService.findById(id);
        if(consultantOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultantService.save(consultantRequestDTO));
    }

}
