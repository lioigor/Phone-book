package com.lioigor22.repositories.impls;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lioigor22.model.Role;
import com.lioigor22.model.User;
import com.lioigor22.model.dtos.EmbeddedRoleDto;
import com.lioigor22.model.dtos.UserDto;
import com.lioigor22.repositories.UserRepositoryJson;
import com.lioigor22.repositories.dao.FileDAO;

@Repository
@Profile("json")
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
				role.setId(temp.getRoleDto().getId());
				role.setName(temp.getRoleDto().getName());
				roles.add(role);
				result.setRoles(roles);

				return result;
			}
		}

		return null;
	}

	@Override
	public void save(User user) {

		List<UserDto> containsList = file.read(jsonFileUrl, UserDto.class);
		long id = getMaximumId(containsList) + 1L;

		UserDto dto = new UserDto();
		dto.setId(id);
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		EmbeddedRoleDto role = new EmbeddedRoleDto();
		role.setId(1L);
		role.setName(USER_ROLE);
		dto.setRoleDto(role);
		dto.setFullName(user.getFullName());

		file.write(jsonFileUrl, dto, UserDto.class);

	}

	private long getMaximumId(List<UserDto> list) {

		long max = 0;
		for (int i = 0; i < list.size(); i++)
			if (max < list.get(i).getId())
				max = list.get(i).getId();
		return max;
	}

}
