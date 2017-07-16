package com.lioigor22.repositories.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.lioigor22.model.Role;
import com.lioigor22.model.dtos.RoleDto;
import com.lioigor22.repositories.JsonRoleRepository;
import com.lioigor22.repositories.dao.FileDAO;

public class JsonRoleRepositoryImpl implements JsonRoleRepository {

	@Value("${json.role.storage}")
	private static String jsonFileUrl;

	@Autowired
	private FileDAO file;

	@Override
	public Role getOne(Long id) {

		Role result = new Role();
		RoleDto temp = new RoleDto();

		for (Object obj : file.read(jsonFileUrl)) {

			temp = (RoleDto) obj;
			if (temp.getId() == id) {
				result.setId(temp.getId());
				result.setName(temp.getName());
			}
		}

		return result;

	}

}
