package com.mycompany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (var container = new AnnotationConfigApplicationContext(AppConfig.class)) {
			EmailClient bean = container.getBean(EmailClient.class);

			bean.sendEmail();
		}
	}
}