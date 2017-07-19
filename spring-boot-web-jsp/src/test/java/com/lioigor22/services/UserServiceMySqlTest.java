// package com.lioigor22.services;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.TestConfiguration;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import com.lioigor22.model.User;
// import com.lioigor22.repositories.UserRepositoryMySql;
// import com.lioigor22.services.UserService;
// import com.lioigor22.services.impls.UserServiceMySql;
//
// @RunWith(SpringRunner.class)
// @ActiveProfiles("mysql")
// public class UserServiceMySqlTest {
//
// @TestConfiguration
// static class UserServiceMySqlTestContextConfiguration {
//
// @Bean
// public UserService userService() {
// return new UserServiceMySql();
// }
// }
//
// @Autowired
// private UserService userService;
//
// @MockBean
// private UserRepositoryMySql userRepositoryMySql;
//
// @Before
// public void setUp() {
//
// User user = new User();
// user.setUsername("alex");
//
// Mockito.when(userRepositoryMySql.findByUsername(user.getUsername())).thenReturn(user);
// }
//
// @Test
// public void whenValidName_thenUserShouldBeFound() {
// String name = "alex";
// User found = userService.findByUsername(name);
//
// assertThat(found.getUsername()).isEqualTo(name);
// }
//
// }
