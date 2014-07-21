package com.epam.jjp.sc.domain;

public class Sith extends ForceUser {

	public Sith(String name, Gender gender) {
		super(name, gender, Force.DARK);
	}

	@Override
	public Force getAllegiance() {
		return getForce();
	}

}
