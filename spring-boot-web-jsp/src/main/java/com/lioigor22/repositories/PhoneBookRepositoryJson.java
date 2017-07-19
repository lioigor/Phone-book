package com.lioigor22.repositories;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

@Profile("json")
public interface PhoneBookRepositoryJson {

	List<PhoneBook> findAllByUser(User user);

	void saveAndFlush(PhoneBook phoneBook);

	PhoneBook getOne(Long id);

	void delete(Long id);

}
