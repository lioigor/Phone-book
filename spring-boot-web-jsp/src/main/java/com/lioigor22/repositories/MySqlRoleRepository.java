package com.lioigor22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.Role;

public interface MySqlRoleRepository extends JpaRepository<Role, Long> {

}
