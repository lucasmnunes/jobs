package com.poll.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.poll.api.entity.User;
import com.poll.api.mock.UserMocker;

public class UserDTOTest {
	
	@Test
	public void givenUser_whenValueOf_thenReturnUserDTO() {
		User userMocker = UserMocker.ENTITY;
		UserDTO userDTO = UserDTO.valueOf(userMocker);
		assertNotNull(userDTO);
		assertEquals(userMocker.getId(), userDTO.getId());
		assertEquals(userMocker.getName(), userDTO.getName());
		assertEquals(userMocker.getLogin(), userDTO.getLogin());
	}
	
}
