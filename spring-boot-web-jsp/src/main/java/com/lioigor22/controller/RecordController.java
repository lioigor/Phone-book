package com.lioigor22.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.services.PhoneBookService;
import com.lioigor22.services.UserService;
import com.lioigor22.validators.PhoneBookValidator;

@Controller
public class RecordController {

	static final Logger logger = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	private PhoneBookService phonebookService;

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneBookValidator phonebookValidator;

	@RequestMapping(value = { "/phonebook" }, method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("phonebook", new PhoneBook());

		return "phonebook";
	}

	@Qualifier(value = "phonebookService")
	public void setPhoneBookService(PhoneBookService ps) {
		this.phonebookService = ps;
	}

	@RequestMapping(value = "/phonebooks", method = RequestMethod.GET)
	public String listPhoneBooks(Model model, HttpServletRequest request) {

		model.addAttribute("phonebook", new PhoneBook());
		model.addAttribute("listPhoneBooks", this.phonebookService.findAllByUser(userService.findByUsername(request.getUserPrincipal().getName())));
		return "phonebook";
	}

	@RequestMapping(value = "/phonebooks", method = RequestMethod.POST)
	public String existingPhoneBooks(Model model, HttpServletRequest request) {
		model.addAttribute("phonebook", new PhoneBook());
		model.addAttribute("listPhoneBooks", this.phonebookService.findAllByUser(userService.findByUsername(request.getUserPrincipal().getName())));
		return "phonebook";
	}

	// For add and update phonebook both
	@RequestMapping(value = "/phonebook/add", method = RequestMethod.POST)
	public String addPhoneBook(@ModelAttribute("phonebook") PhoneBook record, BindingResult bindingResult, HttpServletRequest request) {

		phonebookValidator.validate(record, bindingResult);

		if (bindingResult.hasErrors()) {
			return "phonebook";
		}

		record.setUser(userService.findByUsername(request.getUserPrincipal().getName()));

		if (record.getId() == 0) {
			// new phonebook, add it
			this.phonebookService.add(record);
		} else {
			// existing phonebook, call update
			this.phonebookService.update(record);
		}

		return "redirect:/phonebooks";

	}

	@RequestMapping("/remove/{id}")
	public String removePhoneBook(@PathVariable("id") Long id) {

		this.phonebookService.removeById(id);
		return "redirect:/phonebooks";
	}

	@RequestMapping("/edit/{id}")
	public String editPhoneBook(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		model.addAttribute("phonebook", this.phonebookService.getById(id));
		model.addAttribute("listPhoneBooks", this.phonebookService.findAllByUser(userService.findByUsername(request.getUserPrincipal().getName())));

		return "phonebook";
	}

}
