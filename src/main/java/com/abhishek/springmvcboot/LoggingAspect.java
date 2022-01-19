package com.abhishek.springmvcboot;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Component
@Service
public class LoggingAspect 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution( public * com.abhishek.springmvcboot.AlienController.getAliens())")
	public void log() 
	{
		System.out.println("getAliens method called");
	}
}
