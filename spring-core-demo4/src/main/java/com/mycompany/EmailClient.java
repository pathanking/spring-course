package com.mycompany;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailClient {

	private SpellChecker spellChecker;

	public EmailClient(@Qualifier("adv") SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void sendEmail(String message) {
		spellChecker.spellCheck(message);
	}
}
