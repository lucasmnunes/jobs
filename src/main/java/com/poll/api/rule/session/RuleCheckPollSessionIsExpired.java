package com.poll.api.rule.session;

import java.time.LocalDateTime;

import com.poll.api.entity.PollSession;
import com.poll.api.exception.session.PollSessionExpiredException;

public class RuleCheckPollSessionIsExpired {
	
	private RuleCheckPollSessionIsExpired() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(PollSession pollSession) {
		boolean isPollSessionOpen = pollSession.getEndDate().isAfter(LocalDateTime.now());
		if (!isPollSessionOpen) {
			throw new PollSessionExpiredException(pollSession);
		}
	}
}