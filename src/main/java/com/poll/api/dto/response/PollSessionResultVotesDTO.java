package com.poll.api.dto.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollSessionResultVotesDTO implements Serializable {

	private static final long serialVersionUID = -3058751550775222346L;
	
	private int numberTotalVotes;
	private int numberYesVotes;
	private int numberNoVotes;
	
}

