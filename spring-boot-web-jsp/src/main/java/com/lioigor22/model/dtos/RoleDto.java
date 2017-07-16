package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.lioigor22.model.User;

import lombok.Data;

/**
 * Simple JavaBean object that represents role of {@link User}.
 *
 * @author Igor Likarenko
 * @version 1.0
 */

@Data
// @AllArgsConstructor
@Embeddable
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	public RoleDto() {
	}

	public RoleDto(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + "]";
	}

}
