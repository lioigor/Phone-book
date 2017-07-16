package com.lioigor22.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;
import com.lioigor22.repositories.JsonPhoneBookRepository;
import com.lioigor22.services.PhoneBookService;

@Service
public class PhoneBookServiceJson implements PhoneBookService {

	@Autowired
	private JsonPhoneBookRepository phoneBookRep;

	@Override
	@Transactional
	public void add(PhoneBook phoneBook) {

		this.phoneBookRep.saveAndFlush(phoneBook);
	}

	@Override
	@Transactional
	public void update(PhoneBook phoneBook) {

		this.phoneBookRep.saveAndFlush(phoneBook);

	}

	@Override
	@Transactional
	public PhoneBook getById(Long id) {

		return this.phoneBookRep.getOne(id);
	}

	@Override
	@Transactional
	public void removeById(Long id) {
		this.phoneBookRep.delete(id);
	}

	@Override
	public List<PhoneBook> findAllByUser(User user) {

		return this.phoneBookRep.findAllByUser(user);

	}

}
