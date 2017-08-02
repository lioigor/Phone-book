package com.lioigor22.controller;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.awt.List;
import java.util.ArrayList;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.services.PhoneBookService;
import com.lioigor22.services.UserService;
import com.lioigor22.services.impls.UserServiceMySql;
import com.lioigor22.validators.PhoneBookValidator;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class RecordControllerTest {
	
	private MockMvc mockMvc;

	@Mock
	private PhoneBookService phonebookService;

	@Mock
	private UserService userService;

	@Mock
	private PhoneBookValidator phonebookValidator;

	@InjectMocks
	RecordController sut;

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
	public void home_ShouldAddAttributeToModelAndRenderPhonebookView() throws Exception{
		
		mockMvc.perform(get("/phonebook"))
		  		.andExpect(status().isOk())
		  		.andExpect(view().name("phonebook"))
		  		.andExpect(model().hasNoErrors())
		  		.andExpect(forwardedUrl("/WEB-INF/jsp/phonebook.jsp"))
		  		.andExpect(model().attribute("phonebook", new PhoneBook()));    	        
		
	}
	
	@Test
	public void removePhoneBook_ShouldRemovePhoneBookByIdAndRenderPhonebooksView() throws Exception{
		
		mockMvc.perform(get("/remove/1"))
  			.andExpect(status().isFound())
  			.andExpect(view().name("redirect:/phonebooks"))
  			.andExpect(model().hasNoErrors())
  			.andExpect(redirectedUrl("/phonebooks"));    
		
		verify(phonebookService, times(1)).removeById(1L);
		verifyNoMoreInteractions(phonebookService);
	}
	
	
//	@Test
//	public void listPhoneBooks_ShouldAddTwoAttributesToModelEmptyPhoneBookAndAllPhoneBooks_ThenRenderPhonebookView() throws Exception{
//		
//		MockHttpSession session = new MockHttpSession(); 
//		session.setAttribute("username", "Andrew"); 
//		
//		MockHttpServletRequestBuilder mockBuilder = get("/phonebooks")
//				.contentType(MediaType.TEXT_HTML).session(session);
//		
//		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
//		list.add(new PhoneBook());
//		list.add(new PhoneBook());
//		 
//		Mockito.when(userService.findByUsername(isA(String.class))).thenReturn(quickUserCreator());
//		Mockito.when(phonebookService.findAllByUser(isA(User.class))).thenReturn(list);
//		
//		mockMvc.perform(mockBuilder)
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(view().name("phonebook"))
//			.andExpect(model().hasNoErrors())
//			.andExpect(forwardedUrl("/WEB-INF/jsp/phonebook.jsp"))
//			.andExpect(model().attribute("phonebook", new PhoneBook()))
//			.andExpect(model().attributeExists("listPhoneBooks"));
//			 
//}
		
//		mockMvc.perform(get("/phonebooks"))
//  		.andExpect(status().isOk())
//  		.andExpect(view().name("phonebook"))
//  		.andExpect(model().hasNoErrors())
//  		.andExpect(forwardedUrl("/WEB-INF/jsp/phonebook.jsp"))
//  		.andExpect(model().attribute("phonebook", new PhoneBook()))
//  		.andExpect(model().attributeExists("listPhoneBooks"));
//		
//		verify(userService, times(1)).findByUsername("username");	
//		verify(phonebookService, times(1)).findAllByUser(quickUserCreator());
//		verifyNoMoreInteractions(userService);
		
	

//	@Test
//	public void home_ShouldAddAttributeToModelAndRenderPhonebookView() throws Exception {
//
//		User userTest = quickUserCreator();
//		
//		mockMvc.perform(post("/registration")
//		.param("fullName", userTest.getFullName())
//        .param("username", userTest.getUsername())
//        .param("password", userTest.getPassword())
//        .param("confirmPassword", userTest.getConfirmPassword()))
//  		.andExpect(status().isFound())
//  		.andExpect(model().hasNoErrors())
//  		.andExpect(view().name("redirect:/home"));
//		
//		verify(userService, times(1)).save(userTest);
//		verify(securityService, times(1)).autoUsername(userTest.getUsername(), userTest.getConfirmPassword());
//		verifyNoMoreInteractions(userService);
//		
//	}
	
	private static User quickUserCreator(){
		
		User user = new User();
		user.setFullName("Ivanov Ivan Ivanovich");
		user.setUsername("username");
		user.setPassword("qwerty");
		user.setConfirmPassword("qwerty");
		
		return user;
	}
	
}
