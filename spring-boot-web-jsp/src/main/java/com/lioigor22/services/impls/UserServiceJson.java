package com.lioigor22.services.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.JsonRoleRepository;
import com.lioigor22.repositories.JsonUserRepository;
import com.lioigor22.services.UserService;

@Service
public class UserServiceJson implements UserService {

	@Autowired
	private JsonUserRepository userDao;

	@Autowired
	private JsonRoleRepository roleDao;

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

}
