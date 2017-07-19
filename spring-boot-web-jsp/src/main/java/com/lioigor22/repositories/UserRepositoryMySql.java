package com.lioigor22.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.User;

@Profile("mysql")
public interface UserRepositoryMySql extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
