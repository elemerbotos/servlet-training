package com.epam.jjp.sc.domain;

public class Jedi extends ForceUser {
	public Jedi(String name, Gender gender) {
		super(name, gender, Force.LIGHT);
	}

	@Override
	public Force getAllegiance() {
		return getForce();
	}
}
