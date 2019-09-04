package com.procap.server.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Office {
	
	@Id
	private Integer id;
	
	@NonNull
	private String name;

}
