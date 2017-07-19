package com.lioigor22.services;

import com.lioigor22.model.User;

/**
 * Service class for {@link com.lioigor22.objects.User}
 *
 * @author Igor Likarenko
 * @version 1.0
 */

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
