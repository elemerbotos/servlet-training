package com.epam.jjp.sc.domain;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class Trooper extends Person {
	static int counter = 0;
	private Weapon weapon;
	private MessageSource messages;

	public Trooper(final String name, final Gender gender) {
		super(name + "." + counter, gender);
		setHealthPoints(100);
		++counter;
	}

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	@Override
	public Person fight(final Person person) {
		weapon.hit(person);
		return getHealthPoints() > 0 ? this : null;
	}

	@Override
	public Force getAllegiance() {
		return null;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.Trooper", null,
						Locale.getDefault()), getName(), getGender(),
				weapon.toString());
	}

}
