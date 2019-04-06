package com.poll.api.mock;

import java.util.Optional;

import com.poll.api.dto.PollDTO;
import com.poll.api.entity.Poll;

public abstract class PollMocker {
	
	public static final Long ID = 40L;
	
	public static final String NAME = "Poll Name";
	
	public static final String DESCRIPTION = "Poll Description";
	
	public static final Poll ENTITY = Poll.builder()
			.id(ID)
			.name(NAME)
			.description(DESCRIPTION)
			.build();
	
	public static final Optional<Poll> ENTITY_OPTIONAL = Optional.of(ENTITY);
	
	public static final PollDTO DTO = PollDTO.valueOf(ENTITY);
	
}
