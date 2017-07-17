package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.lioigor22.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple JavaBean object that represents role of {@link User}.
 *
 * @author Igor Likarenko
 * @version 1.0
 */

@Data
@AllArgsConstructor
@Embeddable
public class EmbeddedRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public EmbeddedRoleDto() {
	}

	public EmbeddedRoleDto(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
