package com.excilys.formation.apirestcdb.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.SecurityProperties.Filter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SpringFilter extends HttpFilter {
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//System.out.println("Logging Request  {%s} : {%s}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
		//LOG.info("Logging Response :{}", res.getContentType());
	}
}
