package com.procap.server.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	@Id
	private Integer id;

	private String nome, sobrenome;

}
