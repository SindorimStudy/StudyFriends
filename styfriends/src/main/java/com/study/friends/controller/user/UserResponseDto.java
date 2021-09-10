package com.study.friends.controller.user;

import org.springframework.beans.BeanUtils;
import com.study.friends.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
	private String id;
	private String name;
	private String password;
	private String email;
	private boolean is_admin;
	
	public UserResponseDto(User user) {
		BeanUtils.copyProperties(user, this);
	}
}
