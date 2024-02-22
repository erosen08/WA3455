package com.customers.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String authheader = req.getHeader("authorization");
		
		if (authheader != null && authheader.length() > 0 && authheader.startsWith("Bearer")) {
			chain.doFilter(request, response);
			return;
		}
		
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
	}
}
