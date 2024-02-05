package com.mycompany;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public BasicSpellChecker getBasic() {
		return new BasicSpellChecker();
	}

	@Bean
	public AdvSpellChecker getAdv() {
		return new AdvSpellChecker();
	}

	@Bean
	public EmailClient getEmailClient() {
		EmailClient emailClient = new EmailClient(getBasic());
		return emailClient;
	}
}
