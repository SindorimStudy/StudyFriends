package com.study.friends.controller.user;

import com.study.friends.domain.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
	private String id;
	private String name;
	private String password;
	private String email;
	private boolean is_admin;
	
	public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .is_admin(is_admin)
                .build();
    }
}
