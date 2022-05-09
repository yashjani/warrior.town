package com.thewarriors.us.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DiscordService {

	Logger logger = LoggerFactory.getLogger(DiscordService.class);

	@Autowired
	ExceptionNotificationService exceptionNotificationService;
	

}
