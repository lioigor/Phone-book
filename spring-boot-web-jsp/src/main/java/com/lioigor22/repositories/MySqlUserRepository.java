package com.lioigor22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.User;

public interface MySqlUserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
