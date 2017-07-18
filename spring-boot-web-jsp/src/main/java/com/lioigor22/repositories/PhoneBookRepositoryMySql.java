package com.lioigor22.repositories;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

@Profile("mysql")
public interface PhoneBookRepositoryMySql extends JpaRepository<PhoneBook, Long> {

	List<PhoneBook> findAllByUser(User user);

}
