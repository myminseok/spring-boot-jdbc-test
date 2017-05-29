package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootJdbcTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcTestApplication.class, args);
	}
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value= "/")
	public List<User> list(){
		return userService.users();
	}
	

	@RequestMapping(value="/user/{name}", method = RequestMethod.POST)
	public void addUser(@PathVariable String name){
		 userService.addUser(name);
	}
	

	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
	public void list(@PathVariable Integer id){
		 userService.deleteUser(id);
	}
}
