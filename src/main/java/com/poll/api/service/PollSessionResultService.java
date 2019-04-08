package com.poll.api.service;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poll.api.dto.PollDTO;
import com.poll.api.dto.response.PollSessionResultDTO;
import com.poll.api.dto.response.PollSessionResultVotesDTO;
import com.poll.api.entity.PollSession;
import com.poll.api.entity.Polling;
import com.poll.api.model.VoteOption;
import com.poll.api.rule.polling.RulePollingCalculateNumberVotesOf;

@Service
public class PollSessionResultService {

	public PollSessionResultDTO createPollSessionResult(PollSession pollSession, List<Polling> pollings) {
		return PollSessionResultDTO.builder()
				.pollDTO(PollDTO.valueOf(pollSession.getPoll()))
				.durationMinutes(Duration.between(pollSession.getStartDate(), pollSession.getEndDate()).toMinutes())
				.pollSessionResultVotesDTO(createPollSessionResultVotes(pollings))
				.build();
	}
	
	private PollSessionResultVotesDTO createPollSessionResultVotes(List<Polling> pollings) {
		return PollSessionResultVotesDTO.builder()
				.numberTotalVotes(pollings.size())
				.numberYesVotes(RulePollingCalculateNumberVotesOf.process(VoteOption.YES, pollings))
				.numberNoVotes(RulePollingCalculateNumberVotesOf.process(VoteOption.NO, pollings))
				.build();
	}

}
