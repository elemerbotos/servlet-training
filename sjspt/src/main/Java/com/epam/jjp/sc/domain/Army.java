package com.epam.jjp.sc.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

public class Army {
	private Map<TypeOfSoldier, List<Person>> soldiers;
	private List<ForceUser> forceUsers;
	private MessageSource messages;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public Army(Map<TypeOfSoldier, List<Person>> soldiers) {
		this.soldiers = soldiers;
		forceUsers = new ArrayList<>();
	}

	public Army() {
		soldiers = new HashMap<>();
		forceUsers = new ArrayList<>();
	}

	public void setSoldiers(Map<TypeOfSoldier, List<Person>> soldiers) {
		this.soldiers.clear();
		this.soldiers.putAll(soldiers);
	}

	public void setJedis(List<ForceUser> jedis) {
		this.forceUsers.clear();
		this.forceUsers.addAll(jedis);
	}

	public void addJedis(List<ForceUser> jedis) {
		this.forceUsers.addAll(jedis);
	}

	public void addSoldiers(Map<TypeOfSoldier, List<Person>> soldiers) {
		this.soldiers.putAll(soldiers);
	}

	public List<ForceUser> getJedis() {
		return forceUsers;
	}

	public Map<TypeOfSoldier, List<Person>> getSoldiers() {
		return Collections.unmodifiableMap(soldiers);
	}

	public List<Person> getDefenders() {
		if(soldiers
				.get(TypeOfSoldier.DEFENDER) == null) {
			return new ArrayList<Person>();
		}
		return Collections.unmodifiableList(soldiers
				.get(TypeOfSoldier.DEFENDER));
	}

	public List<Person> getAttackers() {
		if(soldiers
				.get(TypeOfSoldier.ATTACKER) == null) {
			return new ArrayList<Person>();
		}
		return Collections.unmodifiableList(soldiers
				.get(TypeOfSoldier.ATTACKER));
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(messages.getMessage("Army.Soldiers", null,
				Locale.getDefault())
				+ ":\n");
		for (Object key : soldiers.keySet()) {
			for (Person p : soldiers.get(key)) {
				strBuilder.append(p.toString() + "\n");
			}
		}
		strBuilder.append(messages.getMessage("Army.Jedis", null,
				Locale.getDefault())
				+ ":\n");
		for (ForceUser j : forceUsers) {
			strBuilder.append(j.toString() + "\n");
		}
		return strBuilder.toString();
	}

	public int size() {
		return forceUsers.size() + soldiers.size();
	}
}