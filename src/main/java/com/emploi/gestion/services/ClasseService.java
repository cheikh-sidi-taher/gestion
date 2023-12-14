package com.emploi.gestion.services;

import java.util.List;

import com.emploi.gestion.dto.ClasseDTO;



public interface ClasseService {
    List<ClasseDTO> getAllClasses();
    ClasseDTO getClassById(Long id);
    ClasseDTO saveClass(ClasseDTO classeDTO);
    void deleteClass(Long id);
    
}