package com.study.friends.repository;
import com.study.friends.domain.Role;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.friends.StyfriendsApplicationTests;
import com.study.friends.domain.User;
import com.study.friends.service.UserService;

public class UserRepositoryTest extends StyfriendsApplicationTests{
	@Autowired
	private UserService userService;
	
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
		System.out.println(user);
		System.out.println(user.getRoleKey());
	}
	
	@Test
	public void searchByEmail() {
		User user = userService.searchUserByEmail("test");
		System.out.println(user);
	}
	
	@Test
	@Order(4)
	public void delete() {
		User user = userService.searchUser(1L);
		System.out.println(userService.deleteUser(user.getId()));
	}

}
