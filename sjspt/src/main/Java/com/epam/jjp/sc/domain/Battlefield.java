package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class Battlefield {
	private final String name;
	private Army[] armies;
	public static final int DEFENDER = 0;
	public static final int ATTACKER = 1;
	private MessageSource messages;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public Battlefield(final String name, final Army[] armies) {
		this.name = name;
		this.armies = armies;
	}

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.Battlefield", null,
						Locale.getDefault()), name, armies[0].toString(),
				armies[1].toString());
	}

	public Army getArmy(final int role) {
		if (role == DEFENDER || role == ATTACKER) {
			return armies[role];
		} else {
			throw new IllegalArgumentException(
					"Wrong index! (Battlefield.DEFENDER or ATTACKER)");
		}
	}

	public void setArmy(Army army, final int role) {
		if (role == DEFENDER || role == ATTACKER) {
			armies[role] = army;
		} else {
			throw new IllegalArgumentException(
					"Wrong role! (Battlefield.DEFENDER or ATTACKER)");
		}
	}
	
	public Army[] getArmies() {
		return armies;
	}

	public String getName() {
		return name;
	}
}
