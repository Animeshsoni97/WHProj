package com.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * just for welcome page configuration
 */
@Controller
public class WelcomeController {
/*
 * this is go generate welcome page
 */
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}//welcome()
}//class
