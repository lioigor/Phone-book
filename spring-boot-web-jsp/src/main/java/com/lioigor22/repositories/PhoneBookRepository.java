package com.lioigor22.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Long> {

	List<PhoneBook> findAllByUser(User user);

}
