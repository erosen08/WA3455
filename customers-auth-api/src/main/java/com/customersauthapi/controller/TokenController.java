package com.customersauthapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customersauthapi.authentication.Authenticator;
import com.customersauthapi.authentication.JWTHelper;
import com.customersauthapi.authentication.JWTUtil;
import com.customersauthapi.authentication.Token;
import com.customersauthapi.domain.TokenRequestData;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> getToken(@RequestBody TokenRequestData tokenRequestData) {
		String username = tokenRequestData.getUsername();
		String password = tokenRequestData.getPassword();
		String scopes = tokenRequestData.getScopes();
		
		if (username != null && username.length() > 0
			&& password != null && password.length() > 0
			&& Authenticator.checkPassword(username, password)) {
			Token token = jwtUtil.createToken(scopes);
			
			ResponseEntity<?> response = ResponseEntity.ok(token);
			return response;
		}
		
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
}
