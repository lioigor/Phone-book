package com.lioigor22.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.Role;

@Profile("mysql")
public interface RoleRepositoryMySql extends JpaRepository<Role, Long> {

}
