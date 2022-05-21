package com.thewarriors.us;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thewarriors.us.service.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

//@Configuration
public class BotConfiguration {

	Logger logger = LoggerFactory.getLogger(BotConfiguration.class);

	@Value("${botToken}")
	private String botToken;

	@Bean
	public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
		GatewayDiscordClient client = DiscordClientBuilder.create(botToken).build().login().block();

		for (EventListener<T> listener : eventListeners) {
			client.on(listener.getEventType()).flatMap(listener::execute).onErrorResume(listener::handleError)
					.subscribe();
		}

		return client;
	}
}
