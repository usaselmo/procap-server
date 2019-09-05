package com.procap.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procap.server.model.Usuario;
import com.procap.server.repo.UsuarioRepo;

@Service
public class UserService {

	@Autowired
	private UsuarioRepo usuarioRepo;

	public Iterable<Usuario> getUsers() {
		return this.usuarioRepo.findAll();
	}

}
