package com.poll.api.rule.session;

import org.junit.Test;

import com.poll.api.exception.polling.UserAlreadyVotedInPollSessionException;
import com.poll.api.mock.PollingMocker;

public class RuleCheckUserAlreadyVotedInPollSessionTest {
	
	@Test(expected = UserAlreadyVotedInPollSessionException.class)
	public void givenUserAlreadyVoted_whenRuleCheckUserAlreadyVotedInPollSession_thenThrowPollingUserAlreadyVotedException() {
	    RuleCheckUserAlreadyVotedInPollSession.process(PollingMocker.ENTITY);	
	}
	
	@Test
	public void givenUserNotAlreadyVoted_whenRuleCheckUserAlreadyVotedInPollSession_thenNoException() {
	    RuleCheckUserAlreadyVotedInPollSession.process(null);	
	}
	
}