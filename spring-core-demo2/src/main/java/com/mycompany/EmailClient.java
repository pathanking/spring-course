package com.mycompany;

public class EmailClient {

	private SpellChecker spellChecker;

	public EmailClient(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void sendEmail(String message) {
		spellChecker.spellCheck(message);
	}

	public void init() {
		System.out.println("EmailClient bean is getting initialized!");
	}

	public void destroy() {
		System.out.println("EmailClient bean is being destroyed!!");
	}
}
