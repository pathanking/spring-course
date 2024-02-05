package com.mycompany;

public class AdvSpellChecker implements SpellChecker {

	@Override
	public void spellCheck(String message) {
		if (!message.isBlank()) {
			System.out.println("Spell Check Under Process... "+ message);
			try {
				Thread.sleep(5000);
				System.out.println("Done! Spell Check Completed By " + getClass().getSimpleName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else
			throw new IllegalArgumentException("Email Can't Null or Blank!!");
	}
}