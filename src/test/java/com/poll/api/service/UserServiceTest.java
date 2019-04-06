package com.poll.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.poll.api.entity.User;
import com.poll.api.mock.UserMocker;
import com.poll.api.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Before
    public void setUp() {
        when(repository.findById(UserMocker.ID)).thenReturn(UserMocker.ENTITY_OPTIONAL);
        when(repository.save(any(User.class))).thenReturn(UserMocker.ENTITY);
    }
	
	@Test
	public void whenFindAll_thenCallRepositoryOnce() {
		service.findAll();    	
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void givenUserId_whenFindById_thenCallRepositoryOnce() {
		service.findById(UserMocker.ID);    	
		verify(repository, times(1)).findById(UserMocker.ID);
	}
	
	@Test
	public void givenUser_whenSave_thenCallRepositoryAndReturnUser() {
		service.save(UserMocker.DTO);    	
		assertEquals("User Name", repository.save(UserMocker.ENTITY).getName());
	}
	
}
