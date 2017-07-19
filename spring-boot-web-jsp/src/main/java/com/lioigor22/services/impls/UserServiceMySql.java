package com.lioigor22.services.impls;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.RoleRepositoryMySql;
import com.lioigor22.repositories.UserRepositoryMySql;
import com.lioigor22.services.UserService;

/***
 * Implementation of{
 * 
 * @link UserService} interface.
 *
 * @author Igor Likarenko
 * @version 1.0
 */

@Service
@Profile("mysql")
public class UserServiceMySql implements UserService {

	@Autowired
	private UserRepositoryMySql userRepositoryMySql;

	@Autowired
	private RoleRepositoryMySql roleRepositoryMySql;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepositoryMySql.getOne(1L));
		user.setRoles(roles);
		userRepositoryMySql.save(user);
	}

	@Override
	public User findByUsername(String username) {

		return userRepositoryMySql.findByUsername(username);
	}

	@PostConstruct
	private void initRolesForUsers() {

		roleRepositoryMySql.save(new Role(1L, "ROLE_USER"));
		roleRepositoryMySql.save(new Role(2L, "ROLE_ADMIN"));
	}
}
