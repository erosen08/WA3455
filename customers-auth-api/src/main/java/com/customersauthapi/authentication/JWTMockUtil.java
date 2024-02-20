package com.customersauthapi.authentication;

public class JWTMockUtil {
	
	public boolean verifyToken(String jwt_token) {
		if(jwt_token != null && jwt_token.length() > 10) {
			return true;
		}
		return false;
	}
	

}
