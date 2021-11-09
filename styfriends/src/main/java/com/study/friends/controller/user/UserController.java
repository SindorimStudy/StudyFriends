package com.study.friends.controller.user;

import com.study.friends.controller.user.request.UserCreateRequestDto;
import com.study.friends.controller.user.request.UserLoginRequestDto;
import com.study.friends.controller.user.response.UserResponseDto;
import com.study.friends.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.study.friends.service.UserService;
import com.study.friends.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
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
	public ResponseEntity<UserResponseDto> searchUser(@PathVariable final Long userId) {
		User user = userService.searchUser(userId);
		if (user != null) {
			return ResponseEntity.ok(
					new UserResponseDto(userService.searchUser(userId))
			);
		} else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	public ResponseEntity<?> createUser(@Validated  @RequestBody final UserCreateRequestDto userCreateRequestDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
			// 404 request
			return ResponseEntity.ok(new ErrorResponse("404", "Validation failure", errors));
		}
		final User user = userService.searchUserByEmail(userCreateRequestDto.toEntity().getEmail());
		if(user==null) {
			return ResponseEntity.ok(
					new UserResponseDto(userService.createUser(userCreateRequestDto.toEntity())));
		}
		return ResponseEntity.ok(
				new UserResponseDto(userService.searchUserByEmail(userCreateRequestDto.toEntity().getEmail()))
		);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(
			@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity("user deleted", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
		User user = userService.loginUser(userLoginRequestDto);
		if (user != null) return ResponseEntity.ok(user);
		else return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
