package com.in28minutes.jee;

public class LoginValidationService {

	public boolean validateUser(String user, String password) {
		if(user.equals("wilmon") && password.equals("abc123"))
			return true;
		
		return false;
	}
	
}
