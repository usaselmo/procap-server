package com.procap.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.procap.server.model.Usuario;
import com.procap.server.service.UserService;

@RestController
@RequestMapping(value = "/private/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/", "" })
	public Iterable<Usuario> getUsers() {
		return this.userService.getUsers();
	}

}
