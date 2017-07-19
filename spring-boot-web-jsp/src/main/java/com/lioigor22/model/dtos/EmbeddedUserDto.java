package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
@Profile("json")
public class EmbeddedUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String username;

	private String password;

	private String fullName;

	@Embedded
	@JsonProperty("Role")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EmbeddedRoleDto getEmbeddedRoleDto() {
		return embeddedRoleDto;
	}

	public void setEmbeddedRoleDto(EmbeddedRoleDto embeddedRoleDto) {
		this.embeddedRoleDto = embeddedRoleDto;
	}

	@Override
	public String toString() {
		return "EmbeddedUserDto [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName + ", embeddedRoleDto=" + embeddedRoleDto + "]";
	}

}
