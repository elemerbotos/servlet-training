package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.springframework.context.MessageSource;

public abstract class Person {
	private String name;
	private int healthPoints;
	private final Gender gender;
	private MessageSource messages;

	public Person(final String name, final Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public abstract Force getAllegiance();

	public abstract Person fight(final Person person);

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.Person", null,
						Locale.getDefault()), name, gender);
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	/***
	 * Decrease the health points, it can be only decreased to 0
	 * @param damage The damage suffered
	 */
	public void sufferDamage(int damage) {
		if (healthPoints < damage) {
			healthPoints = 0;
		} else {
			healthPoints -= damage;
		}
	}
}
