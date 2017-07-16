package com.lioigor22.repositories.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.User;
import com.lioigor22.model.dtos.PhoneBookDto;
import com.lioigor22.repositories.JsonPhoneBookRepository;
import com.lioigor22.repositories.dao.FileDAO;

public class JsonPhoneBookRepositoryImpl implements JsonPhoneBookRepository {

	@Value("${json.phonebook.storage}")
	private static String jsonFileUrl;

	@Autowired
	private FileDAO file;

	@Override
	public List<PhoneBook> findAllByUser(User user) {

		List<PhoneBook> resultList = new ArrayList<>();

		PhoneBook result = new PhoneBook();
		PhoneBookDto temp = new PhoneBookDto();

		for (Object obj : file.read(jsonFileUrl)) {

			temp = (PhoneBookDto) obj;
			if (temp.getUserDto().getUsername().equals(user.getUsername())) {

				result.setId(temp.getId());
				result.setAddress(temp.getAddress());
				result.setEmail(temp.getEmail());
				result.setHomePhone(temp.getHomePhone());
				result.setMobilePhone(temp.getMobilePhone());
				result.setName(temp.getName());
				result.setPatronymic(temp.getPatronymic());
				result.setSurName(temp.getSurName());

				User userTemp = new User();
				userTemp.setFullName(temp.getUserDto().getFullName());
				userTemp.setId(temp.getUserDto().getId());
				userTemp.setPassword(temp.getUserDto().getPassword());
				userTemp.setUsername(temp.getUserDto().getUsername());
				result.setUser(userTemp);

				resultList.add(result);

			}
		}

		return resultList;
	}

	@Override
	public void saveAndFlush(PhoneBook phoneBook) {

	}

	@Override
	public PhoneBook getOne(Long id) {

		return new PhoneBook();

	}

	@Override
	public void delete(Long id) {

	}

}
