package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.springframework.context.MessageSource;

public abstract class ForceUser extends Person {
	private static final int LIFE_OF_FORCE_USERS = 1000;
	private Force force;
	private LightSabre lightSabre;
	private MessageSource messages;

	public ForceUser(final String name, final Gender gender) {
		super(name, gender);
		setHealthPoints(1000);
	}

	public ForceUser(final String name, final Gender gender, final Force force) {
		this(name, gender);
		this.force = force;
		setHealthPoints(LIFE_OF_FORCE_USERS);
	}

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public void setLightSabre(LightSabre lightSabre) {
		this.lightSabre = lightSabre;
	}

	public LightSabre getLightSabre() {
		return lightSabre;
	}

	@Override
	public String toString() {
		return String.format(messages.getMessage("ToString.ForceUser", null,
				Locale.getDefault()), getName(), getLightSabre().toString());
	}

	@Override
	public Person fight(Person person) {
		lightSabre.hit(person);
		return getHealthPoints() > 0 ? this : null;
	}

	public Force getForce() {
		return force;
	}
}
