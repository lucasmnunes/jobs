package com.poll.api.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollSessionRequestDTO implements Serializable {

	private static final long serialVersionUID = 8441156320104607455L;

	@NotNull(message = "{pollsession.poll.notempty}")
	private Long pollId;

	private Integer duration;

}
