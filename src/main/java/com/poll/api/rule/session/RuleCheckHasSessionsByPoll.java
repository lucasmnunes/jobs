package com.poll.api.rule.session;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.poll.api.entity.Poll;
import com.poll.api.entity.PollSession;
import com.poll.api.exception.session.NoPollSessionByPollException;

public class RuleCheckHasSessionsByPoll {
	
	private RuleCheckHasSessionsByPoll() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(Poll poll, List<PollSession> pollSessions) {
		boolean hasNoPollSessions = CollectionUtils.isEmpty(pollSessions);
		if (hasNoPollSessions) {
			throw new NoPollSessionByPollException(poll.getId());
		}
	}
}