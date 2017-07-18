package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Profile("json")
public class PhoneBookDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String surName;

	private String patronymic;

	private String mobilePhone;

	private String homePhone;

	private String address;

	private String email;

	@Embedded
	@JsonProperty("User")
	private EmbeddedUserDto embeddedUserDto;

	public PhoneBookDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmbeddedUserDto getEmbeddedUserDto() {
		return embeddedUserDto;
	}

	public void setEmbeddedUserDto(EmbeddedUserDto embeddedUserDto) {
		this.embeddedUserDto = embeddedUserDto;
	}

	@Override
	public String toString() {
		return "PhoneBookDto [id=" + id + ", name=" + name + ", surName=" + surName + ", patronymic=" + patronymic + ", mobilePhone=" + mobilePhone + ", homePhone=" + homePhone + ", address=" + address + ", email=" + email + ", phoneBookUserDto="
				+ embeddedUserDto + "]";
	}

}
