package com.lioigor22.repositories;

import com.lioigor22.model.User;

public interface UserRepositoryJson {

	User findByUsername(String username);

	void save(User user);

}
