package com.procap.server;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.procap.server.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

	@Mock
	private UserService userService;

	@Test
	public void getUser_notNull() throws Exception {
		assertThat(this.userService.getUsers(), notNullValue());
	}

	@Test
	public void getUser_isList() throws Exception {
		assertThat(this.userService.getUsers(), CoreMatchers.isA(Iterable.class));
	}

}
