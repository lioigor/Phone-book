package com.lioigor22.repositories.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.model.dtos.EmbeddedRoleDto;
import com.lioigor22.model.dtos.UserDto;
import com.lioigor22.repositories.UserRepositoryJson;
import com.lioigor22.repositories.dao.FileDAO;

@Repository
public class UserRepositoryJsonImpl implements UserRepositoryJson {

	@Value("${json.user.storage}")
	private String jsonFileUrl;
	private static final String USER_ROLE = "ROLE_USER";

	@Autowired
	private FileDAO<UserDto> file;

	@Override
	public User findByUsername(String username) {

		User result = new User();

		for (UserDto temp : file.read(jsonFileUrl, UserDto.class)) {

			if (temp.getUsername().equals(username)) {
				result.setFullName(temp.getFullName());
				result.setId(temp.getId());
				result.setPassword(temp.getPassword());
				result.setUsername(temp.getUsername());

				Set<Role> roles = new HashSet<>();
				Role role = new Role();
				role.setId(1L);
				role.setName(USER_ROLE);
				roles.add(role);
				result.setRoles(roles);

				return result;
			}

		}

		return null;
	}

	@Override
	public void save(User user) {

		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRoleDto(new EmbeddedRoleDto(USER_ROLE));
		dto.setFullName(user.getFullName());

		file.write(jsonFileUrl, dto, UserDto.class);

	}

}
