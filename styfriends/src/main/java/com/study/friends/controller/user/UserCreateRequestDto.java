package com.study.friends.controller.user;

import com.study.friends.domain.Role;
import com.study.friends.domain.User;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {
	private Long id;
	private String name;
	private String password;
	private String email;
	private String picture;
	private Role role;
	
	public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
				.picture(picture)
                .role(role)
                .build();
    }
}
