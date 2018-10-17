package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String sayHello() {
		return "login";
	}
	
	@RequestMapping(value="/loginHelloString")
	@ResponseBody
	public String sayHelloString() {
		return "Hello World dummy";
	}

	
	/* All requests go to the dispatcher servlet
	 * Dispatcher search hello world as URL or view 
	 * Response Body will makes dispatcher think that what response received
	 * is not a URL or view
	 */
}
