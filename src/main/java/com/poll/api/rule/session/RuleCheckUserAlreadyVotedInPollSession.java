package com.poll.api.rule.session;

import java.util.Optional;

import com.poll.api.entity.Polling;
import com.poll.api.exception.polling.UserAlreadyVotedInPollSessionException;

public class RuleCheckUserAlreadyVotedInPollSession {
	
	private RuleCheckUserAlreadyVotedInPollSession() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(Polling polling) {
		boolean userAlreadyVoted = Optional.ofNullable(polling).isPresent();
		if (userAlreadyVoted) {
			throw new UserAlreadyVotedInPollSessionException(polling);
		}		
	}
}