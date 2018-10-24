package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.login.LoginValidationService;

@Controller
@SessionAttributes("bagoPangalan")
public class LoginController {
	
	@Autowired
	LoginValidationService service;
	
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
		//whatever you put in bagoPangalan, it wil automatically available in session attributes
		//do not use session attribute to control the flow of web application
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
