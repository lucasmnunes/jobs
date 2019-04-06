package com.poll.api.rule.user;

import org.apache.commons.lang3.RandomStringUtils;

public class RuleUserGenerateRandomPassword {
	
	private static final int PASSWORD_LENGTH = 8;
	
	private RuleUserGenerateRandomPassword() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static String process() {
		return RandomStringUtils.randomAlphabetic(PASSWORD_LENGTH);
	}
	
}