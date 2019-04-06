package com.poll.api.rule.session;

import java.time.LocalDateTime;

import com.poll.api.entity.PollSession;
import com.poll.api.exception.session.PollSessionRunningException;

public class RuleCheckPollSessionIsRunning {
	
	private RuleCheckPollSessionIsRunning() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(PollSession pollSession) {
		LocalDateTime now = LocalDateTime.now();
		boolean isPollRunning = pollSession.getEndDate().isAfter(now) && pollSession.getStartDate().isBefore(now);
		if (isPollRunning) {
			throw new PollSessionRunningException(pollSession);
		}
	}
}