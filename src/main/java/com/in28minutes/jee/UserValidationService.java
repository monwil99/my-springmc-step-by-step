package com.in28minutes.jee;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if(user.equals("wilmon") && password.equals("abc123"))
			return true;
		
		return false;
	}
	
}
