package com.myorg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		System.out.println("inside home");
		return "index";
	}
	
	@GetMapping("/welcome")
	public String home2() {
		System.out.println("inside home2...");
		return "welcome";
	}
}
