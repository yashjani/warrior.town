package com.thewarriors.us.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

public interface EventListener<T extends Event> {

	Logger LOG = LoggerFactory.getLogger(EventListener.class);

	Class<T> getEventType();

	Mono<Void> execute(T event);

	default Mono<Void> handleError(Throwable error) {
		LOG.error("Unable to process " + getEventType().getSimpleName(), error);
		return Mono.empty();
	}
}