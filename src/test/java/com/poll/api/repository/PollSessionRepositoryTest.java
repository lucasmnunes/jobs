package com.poll.api.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollSessionRepositoryTest {
	
	@Autowired
	private PollSessionRepository repository;

	@Test
	public void testPollSessionRepository() {	
		assertNotNull(repository.findAll());
	}

}
