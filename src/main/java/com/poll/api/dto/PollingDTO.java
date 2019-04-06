package com.poll.api.dto;

import java.io.Serializable;

import com.poll.api.entity.Polling;
import com.poll.api.model.VoteOption;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollingDTO implements Serializable {
	
	private static final long serialVersionUID = -5038463692516440871L;
	
	private Long pollSessionId;
	private Long userId;
	private VoteOption vote;
	
	public static PollingDTO valueOf(Polling polling) {
		return PollingDTO.builder()
				.pollSessionId(polling.getPollSession().getId())
				.userId(polling.getUser().getId())
				.vote(polling.getVote())
				.build();
	}
	
}
