package com.procap.server.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {

	public Usuario() {
	}

	@Id
	@NonNull
	private Integer id;

	private String nome, sobrenome;

	@ManyToOne(targetEntity = Office.class, fetch = FetchType.EAGER)
	private Office office;

}
