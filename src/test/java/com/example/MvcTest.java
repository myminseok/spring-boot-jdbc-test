package com.example;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(SpringBootJdbcTest2Application.class)
public class MvcTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void test() throws Exception {
		List<User> expect= new ArrayList();
		expect.add(new User("a"));

		given(this.userService.users()).willReturn(expect);
		
		this.mvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(content().string("[{\"id\":null,\"name\":\"a\"}]"));
	}
}
