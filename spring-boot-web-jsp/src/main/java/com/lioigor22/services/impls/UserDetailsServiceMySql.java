package com.lioigor22.services.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.UserRepositoryMySql;

/***
 * Implementation of*{
 * 
 * @link org.springframework.security.core.userdetails.UserDetailsService}
 *       interface.
 *
 * @author Igor Likarenko
 */
@Service
@Profile("mysql")
public class UserDetailsServiceMySql implements UserDetailsService {

	@Autowired
	private UserRepositoryMySql userDao;

	// Here as username is user's username (quick and simple)
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
