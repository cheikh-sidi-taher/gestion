package com.emploi.gestion.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.emploi.gestion.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}