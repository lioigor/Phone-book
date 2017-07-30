package com.lioigor22.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lioigor22.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("mysql")
public class UserRepositoryMySqlIT {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepositoryMySql userRepository;

	@Test
	public void whenFindByUsername_thenReturnUser() {

		// given
		User user = new User();
		user.setUsername("alex");
		entityManager.persist(user);
		entityManager.flush();

		// when
		User found = userRepository.findByUsername(user.getUsername());

		// then
		assertThat(found.getUsername()).isEqualTo(user.getUsername());
	}

}
