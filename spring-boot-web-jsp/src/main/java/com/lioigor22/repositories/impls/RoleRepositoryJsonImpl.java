package com.lioigor22.repositories.impls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.lioigor22.model.Role;
import com.lioigor22.model.dtos.RoleDto;
import com.lioigor22.repositories.RoleRepositoryJson;
import com.lioigor22.repositories.dao.FileDAO;

@Repository
@Profile("json")
public class RoleRepositoryJsonImpl implements RoleRepositoryJson {

	@Value("${json.role.storage}")
	private String jsonFileUrl;

	@Autowired
	private FileDAO<RoleDto> file;

	@Override
	public Role getOne(Long id) {

		Role result = new Role();

		for (RoleDto role : file.read(jsonFileUrl, RoleDto.class)) {

			if (role.getId() == id) {
				result.setId(role.getId());
				result.setName(role.getName());

				return result;
			}
		}

		return result;

	}

	@Override
	public void replacedSave(List<Role> roles) {

		List<RoleDto> result = new ArrayList<>();

		for (Role role : roles) {

			RoleDto temp = new RoleDto();
			temp.setId(role.getId());
			temp.setName(role.getName());
			result.add(temp);

		}
		file.writeWithReplace(jsonFileUrl, result);
	}

}
