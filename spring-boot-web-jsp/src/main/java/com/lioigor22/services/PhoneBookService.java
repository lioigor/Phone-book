package com.lioigor22.services;

import java.util.List;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

public interface PhoneBookService {

	public void add(PhoneBook record);

	public void update(PhoneBook record);

	public List<PhoneBook> findAllByUser(User user);

	public PhoneBook getById(Long id);

	public void removeById(Long id);

}
