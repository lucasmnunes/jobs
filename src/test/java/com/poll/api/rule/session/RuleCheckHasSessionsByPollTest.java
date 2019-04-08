package com.poll.api.rule.session;

import org.junit.Test;

import com.poll.api.exception.session.NoPollSessionByPollException;
import com.poll.api.mock.PollMocker;
import com.poll.api.mock.PollSessionMocker;

public class RuleCheckHasSessionsByPollTest {
	
	@Test(expected = NoPollSessionByPollException.class)
	public void givenPollWithoutSessions_whenRuleCheckHasSessionsByPoll_thenThrowNoPollSessionByPollException() {
		RuleCheckHasSessionsByPoll.process(PollMocker.ENTITY, null);
	}

	@Test
	public void givenPollWithSessions_whenRuleCheckHasSessionsByPoll_thenNoException() {
		RuleCheckHasSessionsByPoll.process(PollMocker.ENTITY, PollSessionMocker.LIST);
	}
	
}