package com.thewarriors.us;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String origin = request.getHeader(HttpHeaders.ORIGIN);
		if (origin != null && !origin.isEmpty()
				&& (origin.equals("https://www.warrior.town") || origin.equals("http://127.0.0.1:3000"))) {
			return true;
		}
		logger.info("[preHandle][" + request + "]" + "[" + request.getMethod()
	      + "]" + request.getRequestURI());
		
		return true;
	}

}
