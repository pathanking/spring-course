package com.mycompany;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		try (var container = new ClassPathXmlApplicationContext("config.xml")) {
			EmailClient bean = container.getBean(EmailClient.class);

			bean.sendEmail("Test Mail");
		}
	}
}