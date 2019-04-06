package com.poll.api.rule.polling;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.poll.api.entity.Polling;
import com.poll.api.model.VoteOption;

public class RulePollingCalculateNumberVotesOf {

	private RulePollingCalculateNumberVotesOf() {
		throw new IllegalStateException("Rule utility class");
	}

	public static int process(VoteOption voteOption, List<Polling> pollings) {
		return pollings.stream()
				.filter(polling -> polling.getVote().equals(voteOption))
				.collect(toList()).size();
	}

}