package com.epam.jjp.sc.domain;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public class BattleOfEndor extends Battle {
	private static Logger LOGGER;

	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	public BattleOfEndor(String name, Battlefield battlefield) {
		super(name, battlefield);
		LOGGER = LoggerFactory.getLogger(BattleOfEndor.class);
	}

	/***
	 * Start the battle, after filling the soldiers queue send them in pairs to fight.
	 */
	@Override
	public void start(PrintWriter printWriter) {
		LOGGER.info(super.toString());
		Queue<Person> attackers = getSoldiers(Battlefield.ATTACKER);
		Queue<Person> defenders = getSoldiers(Battlefield.DEFENDER);

		Person attacker = attackers.poll();
		Person defender = defenders.poll();

		while (attacker != null && defender != null) {
			duel(attacker, defender);
			printWriter.println(String.format(
					messages.getMessage("Combat.TextAfterDuel", null,
							Locale.getDefault()), attacker.getName(),
					attacker.getHealthPoints(), defender.getName(),
					defender.getHealthPoints()));
			if (attacker.getHealthPoints() == 0) {
				printWriter.println(String.format(messages.getMessage(
						"Combat.AccidentalDeath", null, Locale.getDefault()),
						attacker.getName()));
				attacker = attackers.poll();
			}
			if (defender.getHealthPoints() == 0) {
				defender = defenders.poll();
			}
		}

		LOGGER.info(attacker == null ? messages.getMessage(
				"Combat.WinnersAreTheDefenders", null, Locale.getDefault())
				: messages.getMessage("Combat.WinnersAreTheAttackers", null,
						Locale.getDefault()));
		
		if(attacker == null) {
			winner = "ATTACKERS";
		} else {
			winner = "DEFENDERS";
		}
		printWriter.println(winner);
	}

	private void duel(Person attacker, Person defender) {

		if (Math.random() >= 0.5f) {
			attacker.fight(defender);
			if (defender.getHealthPoints() > 0) {
				defender.fight(attacker);
			}
		} else {
			defender.fight(attacker);
			if (attacker.getHealthPoints() > 0) {
				attacker.fight(defender);
			}
		}
	}

	private Queue<Person> getSoldiers(final int role) {
		Queue<Person> result = new LinkedList<>();
		Army attackers = getBattlefield().getArmy(role);
		Iterator<ForceUser> iterOfJedis = attackers.getJedis().iterator();
		Iterator<Person> iterOfAttack = attackers.getAttackers().iterator();
		Iterator<Person> iterOfDefend = attackers.getDefenders().iterator();

		while (iterOfAttack.hasNext()) {
			result.add(iterOfAttack.next());
		}

		while (iterOfDefend.hasNext()) {
			result.add(iterOfDefend.next());
		}

		while (iterOfJedis.hasNext()) {
			result.add(iterOfJedis.next());
		}

		return result;
	}

}
