package com.procap.server.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.procap.server.model.Usuario;

@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {

}
