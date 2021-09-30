package com.study.friends.repository;
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
		boolean is_admin = false;
		
		User user = new User().builder().email(email).password(password).name(name).is_admin(is_admin).build();
		userService.createUser(user);
	}
	
	@Test
	public void searchById() {
		User user = userService.searchUser(1L);
		System.out.println(user);
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
