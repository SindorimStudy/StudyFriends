package com.study.friends.controller.user.request;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {
    private String email;
    private String password;
}
