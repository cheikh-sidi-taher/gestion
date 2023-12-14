 package com.emploi.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emploi.gestion.dto.ClasseDTO;
import com.emploi.gestion.models.Classe;
import com.emploi.gestion.repository.ClasseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository; // You need to create a repository interface

    @Override
    public List<ClasseDTO> getAllClasses() {
        return classeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClasseDTO getClassById(Long id) {
        Classe classe = classeRepository.findById(id).orElse(null);
        return (classe != null) ? convertToDTO(classe) : null;
    }

    @Override
    public ClasseDTO saveClass(ClasseDTO classeDTO) {
        Classe savedClass = classeRepository.save(convertToEntity(classeDTO));
        return convertToDTO(savedClass);
    }

    @Override
    public void deleteClass(Long id) {
        classeRepository.deleteById(id);
    }

    private ClasseDTO convertToDTO(Classe classe) {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setId(classe.getId());
        classeDTO.setName(classe.getName());
        classeDTO.setYear(classe.getYear());
        return classeDTO;
    }

    private Classe convertToEntity(ClasseDTO classeDTO) {
        Classe classe = new Classe();
        classe.setId(classeDTO.getId());
        classe.setName(classeDTO.getName());
        classe.setYear(classeDTO.getYear());
        return classe;
    }
}
