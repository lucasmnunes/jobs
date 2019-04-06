package com.poll.api.rule.session;

import org.junit.Test;

import com.poll.api.exception.session.PollSessionRunningException;
import com.poll.api.mock.PollSessionMocker;

public class RuleCheckPollSessionIsRunningTest {
	
	@Test(expected = PollSessionRunningException.class)
	public void givenOpenPoll_whenRuleCheckPollSessionIsRunning_thenThrowPollRunningException() {
		RuleCheckPollSessionIsRunning.process(PollSessionMocker.ENTITY_OPEN);
	}

	@Test
	public void givenExpiredPoll_whenRuleCheckPollSessionIsRunning_thenNoException() {
		RuleCheckPollSessionIsRunning.process(PollSessionMocker.ENTITY_EXPIRED);
	}
	
}