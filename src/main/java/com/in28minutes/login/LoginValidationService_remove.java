package com.in28minutes.login;

import org.springframework.stereotype.Service;

@Service
public class LoginValidationService_remove {

	public boolean validateUser(String user, String password) {
		if(user.equals("wilmon") && password.equals("abc123"))
			return true;
		
		return false;
	}
	
}
