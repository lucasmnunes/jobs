package com.poll.api.rule.poll;

import org.junit.Test;

import com.poll.api.exception.poll.PollDeleteException;
import com.poll.api.mock.PollMocker;
import com.poll.api.mock.PollSessionMocker;

public class RuleCheckIsPossibleDeletePollTest {
	
	@Test
	public void givenPollWithoutSessions_whenRuleCheckIsPossibleDeletePoll_thenDeletePoll() {
		RuleCheckIsPossibleDeletePoll.process(PollMocker.ENTITY, null);
	}
	
	@Test(expected = PollDeleteException.class)
	public void givenPollWithSessions_whenRuleCheckIsPossibleDeletePoll_thenDontDeletePollAndThrowPollDeleteException() {
		RuleCheckIsPossibleDeletePoll.process(PollMocker.ENTITY, PollSessionMocker.LIST);
	}
}