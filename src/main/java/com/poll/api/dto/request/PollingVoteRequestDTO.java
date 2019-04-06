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

	@NotNull(message = "{polling.pollsession.notempty}")
	private Long pollSessionId;
	
	@NotNull(message = "{polling.user.notempty}")
	private Long userId;
	
	@NotNull(message = "{polling.vote.notempty}")
	private VoteOption vote;
	
}
