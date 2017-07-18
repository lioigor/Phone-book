package com.lioigor22.services.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.RoleRepositoryJson;
import com.lioigor22.repositories.UserRepositoryJson;
import com.lioigor22.services.UserService;

@Service
@Profile("json")
public class UserServiceJson implements UserService {

	@Autowired
	private UserRepositoryJson userDao;

	@Autowired
	private RoleRepositoryJson roleDao;

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

	/**
	 * Initialization method (create json files and add users roles)
	 * 
	 */
	@PostConstruct
	private void initRolesForUsers() {

		List<Role> list = new ArrayList<>();
		list.add(new Role(1L, "ROLE_USER"));
		list.add(new Role(2L, "ROLE_ADMIN"));

		roleDao.replacedSave(list);

	}

}
