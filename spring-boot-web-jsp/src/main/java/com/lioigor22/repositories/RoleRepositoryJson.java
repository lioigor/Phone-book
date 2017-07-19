package com.lioigor22.repositories;

import java.util.List;

import org.springframework.context.annotation.Profile;

import com.lioigor22.model.Role;

@Profile("json")
public interface RoleRepositoryJson {

	Role getOne(Long id);

	void replacedSave(List<Role> roles);

}
