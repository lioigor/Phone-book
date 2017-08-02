package com.lioigor22.services.impls;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lioigor22.model.User;
import com.lioigor22.repositories.RoleRepositoryMySql;
import com.lioigor22.repositories.UserRepositoryMySql;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceMySqlTest {

	@Mock
	private UserRepositoryMySql userRepositoryMySql;

	@Mock
	private RoleRepositoryMySql roleRepositoryMySql;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@InjectMocks
	UserServiceMySql sut;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {

		User user = quickUserCreator();

		when(userRepositoryMySql.save(user)).thenReturn(user);

		User result = sut.save(user);

		assertEquals(0, result.getId());
		assertEquals("Ivanov Ivan Ivanovich", result.getFullName());
		assertEquals("username", result.getUsername());
		assertEquals("qwerty", result.getConfirmPassword());

	}

	@Test
	public void testFindByUsername() {

		User user = quickUserCreator();

		when(userRepositoryMySql.findByUsername("username")).thenReturn(user);

		User result = sut.findByUsername("username");

		assertEquals(0, result.getId());
		assertEquals("Ivanov Ivan Ivanovich", result.getFullName());
		assertEquals("username", result.getUsername());
		assertEquals("qwerty", result.getPassword());
		assertEquals("qwerty", result.getConfirmPassword());

	}

	private static User quickUserCreator() {

		User user = new User();
		user.setFullName("Ivanov Ivan Ivanovich");
		user.setUsername("username");
		user.setPassword("qwerty");
		user.setConfirmPassword("qwerty");

		return user;
	}

}
