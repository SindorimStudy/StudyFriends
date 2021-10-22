package com.study.friends.repository;
import com.study.friends.domain.Role;
import org.junit.After;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.friends.StyfriendsApplicationTests;
import com.study.friends.domain.User;
import com.study.friends.service.UserService;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends StyfriendsApplicationTests{
	@Autowired
	private UserService userService;
	private UserRepository userRepository;

	@After
	public void cleanup() {
		userRepository.deleteAll();
	}
	
	@Test
	public void create() {	
		String name = "test";
		String email = "test";
		String password = "test";
		Role role = Role.USER;
		
		User user = new User().builder().email(email).password(password).name(name).role(role).build();
		userService.createUser(user);
	}
	
	@Test
	public void searchById() {
		User user = userService.searchUser(1L);
		assertThat(user.getRole(),is(Role.USER));
	}
	
	@Test
	public void searchByEmail() {
		User user = userService.searchUserByEmail("test");
		assertThat(user.getName(),is("test"));
	}
	
	@Test
	@Order(4)
	public void delete() {
		User user = userService.searchUser(1L);
		assertThat(userService.deleteUser(user.getId()),is(true));
	}

}
