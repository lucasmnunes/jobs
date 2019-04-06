package com.poll.api.rule.user;

import org.junit.Test;

import com.poll.api.exception.user.UserExistsException;
import com.poll.api.mock.UserMocker;

public class RuleCheckUserAlreadyExistsTest {

	@Test(expected = UserExistsException.class)
	public void givenUser_whenRuleUserExists_thenThrowUserExistsException() {
		RuleCheckUserAlreadyExists.process(UserMocker.ENTITY);
	}

	@Test
	public void givenNoUser_whenRuleUserExists_thenNoException() {
		RuleCheckUserAlreadyExists.process(null);
	}

}