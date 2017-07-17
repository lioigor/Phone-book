package com.lioigor22.repositories;

import java.util.List;

import com.lioigor22.model.Role;

public interface RoleRepositoryJson {

	Role getOne(Long id);

	void replacedSave(List<Role> roles);

}
