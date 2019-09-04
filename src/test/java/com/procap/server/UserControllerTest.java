package com.procap.server;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void root_notFound() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
					.get("")
				).andExpect(status().isNotFound());  
		// @formatter:on 
	}

	@Test
	public void rootSlash_notFound() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
					.get("/")
				).andExpect(status().isNotFound());  
		// @formatter:on 
	}

	@Test
	public void private_notFound() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
					.get("/private")
				).andExpect(status().isNotFound());  
		// @formatter:on 
	}

	@Test
	public void privateSlash_notFound() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
					.get("/private/")
				).andExpect(status().isNotFound());  
		// @formatter:on 
	}

	@Test
	public void users_xml_notAcceptable() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
				.get("/private/api/users")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_XML_VALUE))
				.andExpect(status().isNotAcceptable());  
		// @formatter:on 
	}

	@Test
	@Ignore
	public void users_xml_unsuported() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
				.get("/private/api/users")
				.contentType(MediaType.APPLICATION_XML_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isUnsupportedMediaType());  
		// @formatter:on 
	}

	@Test
	public void users_json_OKMediaType() throws Exception {
		// @formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
				.get("/private/api/users")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());  
		// @formatter:on 
	}

}
