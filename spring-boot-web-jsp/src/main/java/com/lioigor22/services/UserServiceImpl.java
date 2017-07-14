package com.lioigor22.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.RoleRepository;
import com.lioigor22.repositories.UserRepository;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Igor Likarenko
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private RoleRepository roleDao;

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
