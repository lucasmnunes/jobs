package com.poll.api.rule.poll;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.poll.api.entity.Poll;
import com.poll.api.entity.PollSession;
import com.poll.api.exception.poll.PollDeleteException;

public class RuleCheckIsPossibleDeletePoll {
	
	private RuleCheckIsPossibleDeletePoll() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(Poll poll, List<PollSession> pollSessions) {
		boolean hasPollSessions = !CollectionUtils.isEmpty(pollSessions);
		if (hasPollSessions) {
			throw new PollDeleteException(poll.getId());
		}
	}
}