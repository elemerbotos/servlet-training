package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class BlastGun extends Weapon {
	private final static int MAXDAMAGE = 100;
	private MessageSource messages;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public BlastGun(String name, int damage) {
		super(name, damage > MAXDAMAGE ? MAXDAMAGE : damage);
	}

	@Override
	public void hit(Person person) {
		person.sufferDamage(getDamage());
	}

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.BlastGun", null,
						Locale.getDefault()), getName(), getDamage());
	}

}
