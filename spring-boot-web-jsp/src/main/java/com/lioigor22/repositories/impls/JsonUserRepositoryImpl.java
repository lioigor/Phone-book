package com.lioigor22.repositories.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lioigor22.model.User;
import com.lioigor22.model.dtos.RoleDto;
import com.lioigor22.model.dtos.UserDto;
import com.lioigor22.repositories.JsonUserRepository;
import com.lioigor22.repositories.dao.FileDAO;

@Component
public class JsonUserRepositoryImpl implements JsonUserRepository {

	@Value("${json.user.storage}")
	private static String jsonFileUrl;
	private static final String USER_ROLE = "ROLE_USER";

	@Autowired
	private FileDAO file;

	@Override
	public User findByUsername(String username) {

		User result = new User();
		UserDto temp = new UserDto();

		for (Object obj : file.read(jsonFileUrl)) {

			temp = (UserDto) obj;
			if (temp.getUsername().equals(username)) {

				result.setFullName(temp.getFullName());
				result.setId(temp.getId());
				result.setPassword(temp.getPassword());
				result.setUsername(temp.getUsername());

				return result;
			}

		}

		return new User();
	}

	@Override
	public void save(User user) {

		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRoleDto(new RoleDto(USER_ROLE));
		dto.setFullName(user.getFullName());

		file.write(jsonFileUrl, dto);

	}

}
