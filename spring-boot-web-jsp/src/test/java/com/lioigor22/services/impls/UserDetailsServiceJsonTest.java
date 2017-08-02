package com.lioigor22.services.impls;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.repositories.UserRepositoryJson;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceJsonTest {

	@Mock
	private UserRepositoryJson userRepositoryJson;

	@InjectMocks
	UserDetailsServiceJson sut;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadUserByUsername_userFound() {

		User user = new User();
		user.setFullName("Ivanov Ivan Ivanovich");
		user.setUsername("username");
		user.setPassword("qwerty");
		user.setConfirmPassword("qwerty");

		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setId(1L);
		role.setName("ROLE_USER");
		roles.add(role);
		user.setRoles(roles);

		when(userRepositoryJson.findByUsername("username")).thenReturn(user);

		UserDetails result = sut.loadUserByUsername("username");

		assertEquals("username", result.getUsername());
		assertEquals("qwerty", result.getPassword());

	}

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername_userNotFound() {

		when(userRepositoryJson.findByUsername("username")).thenThrow(new UsernameNotFoundException("User not exist!"));

		sut.loadUserByUsername("username");

	}

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername_userNotFoundBecauseReturnedNull() {

		when(userRepositoryJson.findByUsername("username")).thenReturn(null);

		sut.loadUserByUsername("username");

	}

}
