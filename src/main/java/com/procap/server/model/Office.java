package com.procap.server.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
public class Office {

	public Office() {
	}

	@Id
	private Integer id;

	@NonNull
	private String name;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
	private List<Usuario> users;

}
