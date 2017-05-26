package com.example;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
public class JDBCTest {

	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private UserRepository userRepository;
	
	//@Test
	public void test(){
		
		manager.persist(new User("a"));
		manager.persist(new User("b"));
		List<User> users= this.userRepository.findAll();
		assertThat(users.size()).isEqualTo(2);
		assertThat(users.get(0).getName()).isEqualTo("a");
		assertThat(users.get(1).getName()).isEqualTo("b");
		
		this.userRepository.save(new User("c"));
		users= this.userRepository.findAll();
		assertThat(users.size()).isEqualTo(3);
		this.userRepository.deleteAll();
		users= this.userRepository.findAll();
		assertThat(users.size()).isEqualTo(0);
	}
	
	

	@Test
	public void test2(){
		
		this.userRepository.save(new User("a"));
		this.userRepository.save(new User("b"));
		this.userRepository.save(new User("c"));
		List<User> users= this.userRepository.findAll();
		assertThat(users.size()).isEqualTo(3);
		assertThat(users.get(0).getName()).isEqualTo("a");
		assertThat(users.get(1).getName()).isEqualTo("b");
		assertThat(users.get(2).getName()).isEqualTo("c");
		
		this.userRepository.deleteAll();
		users= this.userRepository.findAll();
		assertThat(users.size()).isEqualTo(0);
	}
}
