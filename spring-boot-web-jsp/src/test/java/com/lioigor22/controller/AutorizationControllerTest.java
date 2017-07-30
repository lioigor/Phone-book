package com.lioigor22.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.services.SecurityService;
import com.lioigor22.services.impls.UserServiceMySql;
import com.lioigor22.validators.UserRegistrationValidator;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AutorizationControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserServiceMySql userServiceMySql;

	@Mock
	private UserRegistrationValidator userRegValid;

	@Mock
	SecurityService securityService;

	@InjectMocks
	AutorizationController sut;

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(sut).build();

	}

	@Test
	public void registration_ShouldAddUserEntryToModelAndRenderHomeView() throws Exception {

		User client = new User();
		client.setId(1L);
		client.setFullName("Ivanov Ivan Ivanovich");
		client.setUsername("ivanovich");
		client.setPassword("qwerty");
		client.setConfirmPassword("qwerty");

		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setId(1L);
		role.setName("ROLE_USER");
		roles.add(role);
		role.setId(2L);
		role.setName("ROLE_ADMIN");
		roles.add(role);
		client.setRoles(roles);

		doNothing().when(userServiceMySql).save(client);

		mockMvc.perform(post("/registration")
		.param("fullname", "Ivanov Ivan Ivanovich")
        .param("username", "ivanovich")
        .param("passwordd", "qwerty")
        .param("confirmPassword", "qwerty"))
  		.andExpect(status().isFound())
  		.andExpect(view().name("redirect:/home"));
		
	}

}