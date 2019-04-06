package com.poll.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.poll.api.entity.Poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollDTO implements Serializable {
	
	private static final long serialVersionUID = -9186079629001947644L;

	private Long id;
	
	@NotNull(message = "{poll.name.notempty}")
	private String name;
	
	@NotNull
	@Size(min = 5, message = "{poll.description.size}")
	private String description;
	
	public static PollDTO valueOf(Poll poll) {
		return PollDTO.builder()
				.id(poll.getId())
				.name(poll.getName())
				.description(poll.getDescription())
				.build();
	}
	
	public Poll toEntity() {
		return Poll.builder()
				.id(this.id)
				.name(this.name)
				.description(this.description)
				.build();			
	}
	
}
