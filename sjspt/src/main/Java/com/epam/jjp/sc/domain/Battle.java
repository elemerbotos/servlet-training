package com.epam.jjp.sc.domain;

import java.io.PrintWriter;
import java.util.Locale;

import org.springframework.context.MessageSource;

public abstract class Battle {
	private final String name;
	private final Battlefield battlefield;
	protected MessageSource messages;
	protected String winner = "";

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public Battle(final String name, final Battlefield battlefield) {
		this.name = name;
		this.battlefield = battlefield;
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}
	
	/***
	 * Start a battle
	 * @param printWriter 
	 */
	public abstract void start(PrintWriter printWriter);

	@Override
	public String toString() {
		return String.format(
				messages.getMessage("ToString.Battle", null,
						Locale.getDefault()), name, battlefield.toString());
	}

	public String getName() {
		return name;
	}
	
	public String getWinner() {
		return winner;
	}
}
