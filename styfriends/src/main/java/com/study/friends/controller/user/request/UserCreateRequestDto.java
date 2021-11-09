package com.study.friends.controller.user.request;

import com.study.friends.domain.Role;
import com.study.friends.domain.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {

	@NotBlank(message="NAME_IS_MANDATORY")
	private String name;
	@NotBlank(message="PASSWORD_IS_MANDATORY")
	private String password;
	@NotBlank(message="EMAIL_IS_MANDATORY")
	@Email(message = "NOT_VALID_EMAIL")
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
