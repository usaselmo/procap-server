package com.procap.server.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.procap.server.model.User;

@Service
public class UserService {

	public List<User> getUsers() {
		return Arrays.asList( new User(1, "Anselmo", "Ribeiro"), new User(2, "Luis", "Soares") );
	}

}
