package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.in28minutes.jee.LoginValidationService;

@Controller
public class LoginController {
	
	LoginValidationService service = new LoginValidationService();
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String pangalan, 
			@RequestParam String hudyat,
			ModelMap model) {
		
		if(!service.validateUser(pangalan, hudyat)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("bagoPangalan", pangalan);
		model.put("bagoHudyat", hudyat);
		return "welcome";


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
	
	/*
	 * Model - The way to pass data/information between or from the Controller to the View
	 * 
	 */
}
