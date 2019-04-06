package com.poll.api.mock;

import java.util.Optional;

import com.poll.api.dto.UserDTO;
import com.poll.api.entity.User;

public abstract class UserMocker {
	
	public static final Long ID = 30L;
	
	public static final String NAME = "User Name";
	
	public static final String LOGIN = "User Login";
	
	public static final User ENTITY = User.builder()
			.id(ID)
			.name(NAME)
			.login(LOGIN)
			.build();
	
	public static final Optional<User> ENTITY_OPTIONAL = Optional.of(ENTITY);
	
	public static final UserDTO DTO = UserDTO.valueOf(ENTITY);
	
}
