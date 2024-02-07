package com.myorg.components;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailClient implements InitializingBean, DisposableBean {
	
	@Value("${email.message}")
	private String message;

	private SpellChecker spellChecker;

	@Autowired
	public void setSpellChecker(SpellChecker checker) {
		this.spellChecker = checker;
	}

	public void sendEmail() {
		spellChecker.spellCheck(message);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("EmailClient bean is being destroyed!!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("EmailClient bean is being initialized!!");
	}
}
