package com.poll.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poll.api.dto.UserDTO;
import com.poll.api.entity.User;
import com.poll.api.exception.user.UserNotFoundException;
import com.poll.api.repository.UserRepository;
import com.poll.api.rule.user.RuleCheckUserAlreadyExists;
import com.poll.api.rule.user.RuleUserGenerateRandomPassword;

@Service
public class UserService {

	private final UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public User save(UserDTO userDTO) {
		RuleCheckUserAlreadyExists.process(repository.findByLogin(userDTO.getLogin()));
		return repository.save(createUser(userDTO));
	}
	
	private User createUser(UserDTO userDTO) {
		return User.builder()
				.login(userDTO.getLogin())
				.name(userDTO.getName())
				.password(RuleUserGenerateRandomPassword.process())
				.build();
	}
	
}
