package com.poll.api.rule.poll;

import org.junit.Test;

import com.poll.api.exception.poll.PollAlreadyExistsException;
import com.poll.api.mock.PollMocker;

public class RuleCheckPollExistsTest {

	@Test(expected = PollAlreadyExistsException.class)
	public void givenPoll_whenRuleCheckPollExists_thenThrowPollExistsException() {
		RuleCheckPollExists.process(PollMocker.ENTITY);
	}

	@Test
	public void givenNoPoll_whenRuleCheckPollExists_thenNoException() {
		RuleCheckPollExists.process(null);
	}

}