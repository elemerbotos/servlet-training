package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;

public class LightSabre extends Weapon implements InitializingBean,
		DisposableBean {
	private static Logger LOGGER = LoggerFactory.getLogger(LightSabre.class);
	private MessageSource messages;

	public LightSabre(final String name, final int damage) {
		super(name, damage);
	}

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.LightSabre", null,
						Locale.getDefault()), getName(), getDamage());
	}

	@Override
	public void destroy() {
		LOGGER.info(this.toString() + " auto destroy :(");
	}

	@Override
	public void afterPropertiesSet() {
		LOGGER.info(this.toString() + " is BORN");

	}
}
