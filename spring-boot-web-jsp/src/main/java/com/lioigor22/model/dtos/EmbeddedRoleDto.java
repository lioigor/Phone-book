package com.lioigor22.model.dtos;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.context.annotation.Profile;

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
@Profile("json")
public class EmbeddedRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	public EmbeddedRoleDto() {
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
		return "EmbeddedRoleDto [id=" + id + ", name=" + name + "]";
	}

}
