package com.epam.jjp.sc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.MessageSource;

import com.epam.jjp.sc.domain.BlastGun;

public class BlasterFactoryBean implements FactoryBean<BlastGun> {

	private final int damageRange;
	private static int counter = 0;
	private static final int BASEDAMAGE = 10;
	private final MessageSource messagesource;

	public BlasterFactoryBean(final int damageRange,
			final MessageSource messages) {
		this.messagesource = messages;
		this.damageRange = damageRange;
	}

	@Override
	public BlastGun getObject() throws Exception {
		String name = "BlastGun #" + counter;
		++counter;
		int damage = (int) (Math.random() * damageRange) % 20 + BASEDAMAGE;
		BlastGun blastgun = new BlastGun(name, damage);
		blastgun.setMessages(messagesource);
		return blastgun;
	}

	@Override
	public Class<?> getObjectType() {
		return BlastGun.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
