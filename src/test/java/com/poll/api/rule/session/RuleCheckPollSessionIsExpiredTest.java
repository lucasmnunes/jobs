package com.poll.api.rule.session;

import org.junit.Test;

import com.poll.api.exception.session.PollSessionExpiredException;
import com.poll.api.mock.PollSessionMocker;

public class RuleCheckPollSessionIsExpiredTest {
	
	@Test(expected = PollSessionExpiredException.class)
	public void givenExpiredPoll_whenRuleCheckPollSessionIsExpired_thenThrowPollExpiredException() {
		RuleCheckPollSessionIsExpired.process(PollSessionMocker.ENTITY_EXPIRED);
	}

	@Test
	public void givenNoExpiredPoll_whenRuleCheckPollSessionIsExpired_thenNoException() {
		RuleCheckPollSessionIsExpired.process(PollSessionMocker.ENTITY_OPEN);
	}
	
}