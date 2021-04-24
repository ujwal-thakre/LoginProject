package com.demo.practice;

public class UserValidatorService {

	public boolean isValidaUser(String username, String password) {
		if (username.equals("Ujwal") && password.equals("password")) {
			return true;
		} else {
			return false;
		}
	}
}
