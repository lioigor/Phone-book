package com.lioigor22.repositories;

import org.springframework.context.annotation.Profile;

import com.lioigor22.model.User;

@Profile("json")
public interface UserRepositoryJson {

	User findByUsername(String username);

	void save(User user);

}
