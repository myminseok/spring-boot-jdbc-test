package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootJdbcTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcTest2Application.class, args);
	}
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value= "/")
	public List<User> list(){
		return userService.users();
	}
}
