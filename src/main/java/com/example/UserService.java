package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

	
	List<User> users();
	
	void addUser(String name);
	
	void deleteUser(Integer id);
	
}
