package com.jfs.user.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

 @Component
public class CrossFilter implements Filter {
	
	 
	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
	 
	}

	/**
	 * 
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpRes = (HttpServletResponse) res;
        httpRes.setHeader("Access-Control-Allow-Origin", "*");
        httpRes.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT");
        httpRes.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept,X-Requested-With");
        httpRes.setHeader("Access-Control-Max-Age", "43200");
        chain.doFilter(req, res);
	}
	@Override
	public void destroy()
	{
		 
	}

}