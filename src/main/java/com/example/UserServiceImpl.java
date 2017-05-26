package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
    
	public List<User> users(){
		return userRepository.findAll();
	}
	
	public void addUser(String name){
		userRepository.save(new User(name));
	}
	
	public void deleteUser(Integer id){
		userRepository.delete(id);
	}
}
