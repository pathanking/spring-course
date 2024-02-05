package com.mycompany;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class EmailClient {

	private SpellChecker spellChecker;

	public EmailClient(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void sendEmail(String message) {
		spellChecker.spellCheck(message);
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("EmailClient is being initialized...");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("EmailClient is being destroyed...");
	}
}
