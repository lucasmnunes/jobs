package com.poll.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.poll.api.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2995883972404445864L;

	private Long id;
	
	@NotNull(message = "{user.name.notempty}")
	private String name;
	
	@NotNull
	@Size(min = 5, message = "{user.login.size}")
	private String login;
	
	public static UserDTO valueOf(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.login(user.getLogin())
				.build();
	}
	
}
