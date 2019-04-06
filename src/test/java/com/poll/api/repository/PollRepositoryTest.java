package com.poll.api.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollRepositoryTest {
	
	@Autowired
	private PollRepository repository;

	@Test
	public void testPollRepository() {	
		assertNotNull(repository.findAll());
	}

}
