package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class EmbeddedUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String fullName;

	@Embedded
	private EmbeddedRoleDto embeddedRoleDto;

	public EmbeddedUserDto() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public EmbeddedRoleDto getRoleDto() {
		return embeddedRoleDto;
	}

	public void setRoleDto(EmbeddedRoleDto userRoleDto) {
		this.embeddedRoleDto = userRoleDto;
	}

	@Override
	public String toString() {
		return "PhoneBookUserDto [username=" + username + ", password=" + password + ", fullName=" + fullName + ", userRoleDto=" + embeddedRoleDto + "]";
	}

}
