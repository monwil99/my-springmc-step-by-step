package com.in28minutes.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnotherController {
	
	@RequestMapping(value="/loginAnother")
	public String sayHello() {
		return "login";
	}
	
}
