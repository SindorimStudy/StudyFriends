package com.study.friends.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.friends.domain.User;
import com.study.friends.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
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
	
	public boolean deleteUser(Long userId) {
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}
}	
