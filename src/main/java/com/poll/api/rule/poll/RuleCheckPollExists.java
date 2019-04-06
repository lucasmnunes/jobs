package com.poll.api.rule.poll;

import java.util.Optional;

import com.poll.api.entity.Poll;
import com.poll.api.exception.poll.PollAlreadyExistsException;

public class RuleCheckPollExists {
	
	private RuleCheckPollExists() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static void process(Poll poll) {
		boolean pollExists = Optional.ofNullable(poll).isPresent();
		if (pollExists) {
			throw new PollAlreadyExistsException(poll.getName());
		}		
	}
}