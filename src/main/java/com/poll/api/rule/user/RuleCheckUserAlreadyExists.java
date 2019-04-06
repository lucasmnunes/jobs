package com.poll.api.rule.user;

import java.util.Optional;

import com.poll.api.entity.User;
import com.poll.api.exception.user.UserExistsException;

public class RuleCheckUserAlreadyExists {
	
	private RuleCheckUserAlreadyExists() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(User user) {
		boolean userExists = Optional.ofNullable(user).isPresent();
		if (userExists) {
			throw new UserExistsException(user.getLogin());
		}		
	}
}