package com.study.friends.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.study.friends.service.UserService;
import com.study.friends.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(final UserService userService) {
		this.userService = userService;	
	}
	
	/* get - search
	 * post - create
	 * put/patch - update
	 * delete - delete */
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseDto> searchUser(@PathVariable final String userId) {
		User user = userService.searchUser(userId);
		if(user!=null) {
			return ResponseEntity.ok(
					new UserResponseDto(userService.searchUser(userId))
					);
		}
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDto> createUSer(@RequestBody final UserCreateRequestDto userCreateRequestDto){
		final User user = userService.searchUser(userCreateRequestDto.toEntity().getId());
		if(user!=null) return ResponseEntity.ok(
                new UserResponseDto(userService.searchUser(userCreateRequestDto.toEntity().getId()))
        );
		return ResponseEntity.ok(
                new UserResponseDto(userService.createUser(userCreateRequestDto.toEntity()))
        );
	}
}
