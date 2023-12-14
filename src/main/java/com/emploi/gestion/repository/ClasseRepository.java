package com.emploi.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emploi.gestion.models.Classe;

@Repository   
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    // You can add custom queries here if needed
}

