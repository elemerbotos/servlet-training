package com.epam.jjp.sc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.MessageSource;

import com.epam.jjp.sc.domain.LightSabre;

public class LightSabreFactoryBean implements FactoryBean<LightSabre> {

	private final int damageRange;
	private static int counter = 0;
	private static final int BASEDAMAGE = 40;
	private final MessageSource messages;

	public LightSabreFactoryBean(final int damageRange,
			final MessageSource messages) {
		this.damageRange = damageRange;
		this.messages = messages;
	}

	@Override
	public LightSabre getObject() throws Exception {
		String name = "Light Sabre #" + counter;
		++counter;
		int damage = (int) (Math.random() * damageRange) % 20 + BASEDAMAGE;
		LightSabre lightSabre = new LightSabre(name, damage);
		lightSabre.setMessages(messages);
		return lightSabre;
	}

	@Override
	public Class<?> getObjectType() {
		return LightSabre.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
