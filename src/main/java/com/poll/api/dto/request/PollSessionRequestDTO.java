package com.poll.api.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollSessionRequestDTO implements Serializable {

	private static final long serialVersionUID = 8441156320104607455L;

	@NotNull(message = "Poll cannot be null")
	private Long pollId;

	private Integer duration;

}
