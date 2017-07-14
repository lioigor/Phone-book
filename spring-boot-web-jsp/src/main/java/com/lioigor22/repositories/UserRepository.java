package com.lioigor22.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
