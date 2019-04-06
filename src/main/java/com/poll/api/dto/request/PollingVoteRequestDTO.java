package com.poll.api.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.poll.api.model.VoteOption;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollingVoteRequestDTO implements Serializable {

	private static final long serialVersionUID = 7156264219619737592L;

	@NotNull(message = "Poll Session cannot be null")
	private Long pollSessionId;
	
	@NotNull(message = "User cannot be null")
	private Long userId;
	
	@NotNull(message = "Vote cannot be null")
	private VoteOption vote;
	
}
