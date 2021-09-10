package com.study.friends.repository;
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
		String id = "test";
		String name = "test";
		String email = "test";
		String password = "test";
		boolean is_admin = false;
		
		User user = new User().builder().email(email).id(id).password(password).name(name).is_admin(is_admin).build();
		userService.createUser(user);
	}
	
	@Test
	public void search() {
		String id = "test";
		User user = userService.searchUser(id);
		System.out.println(user);
	}

}
