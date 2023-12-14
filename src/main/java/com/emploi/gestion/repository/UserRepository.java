package com.emploi.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emploi.gestion.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}