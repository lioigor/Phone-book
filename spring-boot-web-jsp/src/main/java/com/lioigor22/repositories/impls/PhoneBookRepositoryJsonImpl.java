package com.lioigor22.repositories.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.lioigor22.model.PhoneBook;
import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.model.dtos.EmbeddedRoleDto;
import com.lioigor22.model.dtos.EmbeddedUserDto;
import com.lioigor22.model.dtos.PhoneBookDto;
import com.lioigor22.repositories.PhoneBookRepositoryJson;
import com.lioigor22.repositories.dao.FileDAO;

@Repository
public class PhoneBookRepositoryJsonImpl<E> implements PhoneBookRepositoryJson {

	@Value("${json.phonebook.storage}")
	private String jsonFileUrl;

	@Autowired
	private FileDAO<PhoneBookDto> file;

	private static final String USER_ROLE = "ROLE_USER";

	@Override
	public List<PhoneBook> findAllByUser(User user) {

		List<PhoneBook> resultList = new ArrayList<>();

		for (PhoneBookDto temp : file.read(jsonFileUrl, PhoneBookDto.class)) {

			PhoneBook result = new PhoneBook();

			if (temp.getEmbeddedUserDto().getUsername().equals(user.getUsername())) {

				result.setId(temp.getId());
				result.setAddress(temp.getAddress());
				result.setEmail(temp.getEmail());
				result.setHomePhone(temp.getHomePhone());
				result.setMobilePhone(temp.getMobilePhone());
				result.setName(temp.getName());
				result.setPatronymic(temp.getPatronymic());
				result.setSurName(temp.getSurName());

				User userTemp = new User();
				userTemp.setFullName(temp.getEmbeddedUserDto().getFullName());
				userTemp.setPassword(temp.getEmbeddedUserDto().getPassword());
				userTemp.setUsername(temp.getEmbeddedUserDto().getUsername());

				result.setUser(userTemp);

				resultList.add(result);

			}
		}

		return resultList;
	}

	@Override
	public void saveAndFlush(PhoneBook phoneBook) {

		List<PhoneBookDto> resultList = new ArrayList<>();

		for (PhoneBookDto temp : file.read(jsonFileUrl, PhoneBookDto.class)) {

			PhoneBookDto forRecord = new PhoneBookDto();

			if (temp.getId() == phoneBook.getId()) {

				forRecord.setAddress(phoneBook.getAddress());
				forRecord.setEmail(phoneBook.getEmail());
				forRecord.setHomePhone(phoneBook.getHomePhone());
				forRecord.setId(phoneBook.getId());
				forRecord.setMobilePhone(phoneBook.getMobilePhone());
				forRecord.setName(phoneBook.getName());
				forRecord.setPatronymic(phoneBook.getPatronymic());
				forRecord.setSurName(phoneBook.getSurName());

				EmbeddedUserDto user = new EmbeddedUserDto();
				user.setFullName(phoneBook.getUser().getFullName());
				user.setPassword(phoneBook.getUser().getPassword());
				user.setUsername(phoneBook.getUser().getUsername());

				EmbeddedRoleDto roleDto = new EmbeddedRoleDto();

				for (Role role : phoneBook.getUser().getRoles()) {

					roleDto.setName(role.getName());
					break;
				}
				user.setRoleDto(roleDto);

				forRecord.setEmbeddedUserDto(user);

				resultList.add(forRecord);
			} else {
				resultList.add(temp);
			}
		}

		file.writeWithReplace(jsonFileUrl, resultList);

	}

	@Override
	public PhoneBook getOne(Long id) {

		PhoneBook result = new PhoneBook();

		for (PhoneBookDto phoneBookDto : file.read(jsonFileUrl, PhoneBookDto.class)) {

			if (phoneBookDto.getId() == id) {
				result.setAddress(phoneBookDto.getAddress());
				result.setEmail(phoneBookDto.getEmail());
				result.setHomePhone(phoneBookDto.getHomePhone());
				result.setId(phoneBookDto.getId());
				result.setMobilePhone(phoneBookDto.getMobilePhone());
				result.setName(phoneBookDto.getName());
				result.setPatronymic(phoneBookDto.getPatronymic());
				result.setSurName(phoneBookDto.getSurName());

				User user = new User();
				user.setFullName(phoneBookDto.getEmbeddedUserDto().getFullName());
				user.setPassword(phoneBookDto.getEmbeddedUserDto().getPassword());
				user.setUsername(phoneBookDto.getEmbeddedUserDto().getUsername());

				Set<Role> roles = new HashSet<>();
				Role role = new Role();
				role.setId(1L);
				role.setName(USER_ROLE);
				roles.add(role);

				user.setRoles(roles);

				result.setUser(user);
				return result;
			}
		}

		return result;

	}

	@Override
	public void delete(Long id) {

		List<PhoneBookDto> resultList = new ArrayList<>();

		for (PhoneBookDto temp : file.read(jsonFileUrl, PhoneBookDto.class)) {

			if (temp.getId() != id) {
				resultList.add(temp);
			}

		}

		file.writeWithReplace(jsonFileUrl, resultList);

	}

}
