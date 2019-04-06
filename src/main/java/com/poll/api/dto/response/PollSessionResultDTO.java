package com.poll.api.dto.response;

import java.io.Serializable;

import com.poll.api.dto.PollDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollSessionResultDTO implements Serializable {

	private static final long serialVersionUID = 4597624288628165397L;
	
	private PollDTO pollDTO;
	private Long durationMinutes;
	private PollSessionResultVotesDTO pollSessionResultVotesDTO;
	
}

