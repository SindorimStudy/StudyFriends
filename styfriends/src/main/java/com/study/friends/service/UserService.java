package com.study.friends.service;

import com.study.friends.controller.user.request.UserLoginRequestDto;
import com.study.friends.controller.user.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.friends.domain.User;
import com.study.friends.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<UserResponseDto> findAll(){
		return userRepository.findAll().stream()
				.map(UserResponseDto::new)
				.collect(Collectors.toList());
	}
	
	public User searchUser(Long userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user;
	}
	
	public User searchUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElse(null);
		return user;
	}
	
	@Transactional
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		// set info
		return userRepository.save(user);
	}

	public User loginUser(UserLoginRequestDto loginRequestDto) {
		User user = searchUserByEmail(loginRequestDto.getEmail());
		if (user==null||!user.getPassword().equals(loginRequestDto.getPassword())){
			return null;
		}
		else return user;
	}

	@Transactional
	public boolean deleteUser(Long userId) {
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
}	
