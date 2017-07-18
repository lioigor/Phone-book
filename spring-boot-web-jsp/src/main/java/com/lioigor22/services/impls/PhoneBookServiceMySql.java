package com.lioigor22.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;
import com.lioigor22.repositories.PhoneBookRepositoryMySql;
import com.lioigor22.services.PhoneBookService;

@Service
@Profile("mysql")
public class PhoneBookServiceMySql implements PhoneBookService {

	@Autowired
	private PhoneBookRepositoryMySql phoneBookRepositoryMySql;

	@Override
	@Transactional
	public void add(PhoneBook phoneBook) {
		this.phoneBookRepositoryMySql.saveAndFlush(phoneBook);
	}

	@Override
	@Transactional
	public void update(PhoneBook phoneBook) {

		this.phoneBookRepositoryMySql.saveAndFlush(phoneBook);

	}

	@Override
	@Transactional
	public PhoneBook getById(Long id) {

		return this.phoneBookRepositoryMySql.getOne(id);
	}

	@Override
	@Transactional
	public void removeById(Long id) {
		this.phoneBookRepositoryMySql.delete(id);
	}

	@Override
	public List<PhoneBook> findAllByUser(User user) {

		return this.phoneBookRepositoryMySql.findAllByUser(user);

	}

}
