package com.lioigor22.repositories;

import java.util.List;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

public interface PhoneBookRepositoryJson {

	List<PhoneBook> findAllByUser(User user);

	void saveAndFlush(PhoneBook phoneBook);

	PhoneBook getOne(Long id);

	void delete(Long id);

}
