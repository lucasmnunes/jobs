package com.poll.api.rule.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RuleUserGenerateRandomPasswordTest {
	
	private static final int PASSWORD_LENGTH = 8;
	
	@Test
	public void whenCallRuleUserGenerateRandomPassword_thenReturnAPassword() {
		assertEquals(false, RuleUserGenerateRandomPassword.process().isEmpty());
	}
	
	@Test
	public void whenCallRuleUserGenerateRandomPassword_thenReturnAPasswordWithEightCharacters() {
		assertEquals(PASSWORD_LENGTH, RuleUserGenerateRandomPassword.process().length());
	}

}