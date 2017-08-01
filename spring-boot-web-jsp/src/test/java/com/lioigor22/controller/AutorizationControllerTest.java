package com.lioigor22.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;
import com.lioigor22.services.SecurityService;
import com.lioigor22.services.UserService;
import com.lioigor22.validators.UserRegistrationValidator;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class AutorizationControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@Mock
	private UserRegistrationValidator userRegValid;

	@Mock
	SecurityService securityService;

	@InjectMocks
	AutorizationController sut;

	@Before
	public void setup() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(sut).setViewResolvers(viewResolver).build();

	}

	@Test
	public void registration_ShouldAddAttributeToModelAndRenderRegistrationView() throws Exception {
		
		mockMvc.perform(get("/registration"))
  		.andExpect(status().isOk())
  		.andExpect(view().name("registration"))
  		.andExpect(model().hasNoErrors())
  		.andExpect(forwardedUrl("/WEB-INF/jsp/registration.jsp"))
  		.andExpect(model().attribute("userForm", new User()));    	
	}
	
	@Test
	public void registration_ShouldAddUserEntryToModelAndRenderHomeView() throws Exception {

		User userTest = quickUserCreator();
		
		mockMvc.perform(post("/registration")
		.param("fullName", userTest.getFullName())
        .param("username", userTest.getUsername())
        .param("password", userTest.getPassword())
        .param("confirmPassword", userTest.getConfirmPassword()))
  		.andExpect(status().isFound())
  		.andExpect(model().hasNoErrors())
  		.andExpect(view().name("redirect:/home"));
		
		verify(userService, times(1)).save(userTest);
		verify(securityService, times(1)).autoUsername(userTest.getUsername(), userTest.getConfirmPassword());
		verifyNoMoreInteractions(userService);
		
	}
	
	@Test
	public void login_ShouldForwardToLoginView() throws Exception{
		
		mockMvc.perform(get("/login"))
		  		.andExpect(status().isOk())
		  		.andExpect(view().name("login"))
		  		.andExpect(model().hasNoErrors())
		  		.andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));    	        
		
	}
	
	@Test
	public void logout_ShouldRedirectToLoginLogoutView() throws Exception{
		
		mockMvc.perform(post("/logout"))
  		.andExpect(status().isFound())
  		.andExpect(view().name("redirect:/login?logout"))
  		.andExpect(model().hasNoErrors());     
		
	}
	
	
	private static User quickUserCreator(){
		
		User user = new User();
		user.setFullName("Ivanov Ivan Ivanovich");
		user.setUsername("ivanovich");
		user.setPassword("qwerty");
		user.setConfirmPassword("qwerty");
		
		return user;
	}

}