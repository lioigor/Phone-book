package com.lioigor22.services.impls;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.MySqlRoleRepository;
import com.lioigor22.repositories.MySqlUserRepository;
import com.lioigor22.services.UserService;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Igor Likarenko
 * @version 1.0
 */

@Service
public class UserServiceMySql implements UserService {

	@Autowired
	private MySqlUserRepository userDao;

	@Autowired
	private MySqlRoleRepository roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDao.getOne(1L));
		user.setRoles(roles);
		userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {

		return userDao.findByUsername(username);
	}

	@PostConstruct
	private void initRolesForUsers() {

		roleDao.save(new Role(1L, "ROLE_USER"));
		roleDao.save(new Role(2L, "ROLE_ADMIN"));
	}
}
