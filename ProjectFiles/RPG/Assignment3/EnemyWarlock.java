package Assignment3;

import java.util.Arrays;

public class EnemyWarlock extends EnemyPlayer{
	
	public EnemyWarlock() {
		SpellSlot1 = new WarlockSpells();//set the spell slots to be looking at Plague spells
		SpellSlot2 = new WarlockSpells();
		SpellSlot3 = new WarlockSpells();
		
		Reward = SpellSlot1.RollOfTheDie(26) + 24; // when this enemy dies this is the ammount the play will gain in gold
		
		MaxHealth = 35;
		CurrentHealth = MaxHealth;
		
		
		
	}
	
	/**
	 * Method that casts the first spell 'SoulDrain' and exausts the approate actions  (Souldrain Heals the user and damages target)
	 */
	public String[] SpellSlot1() {
		IncommingSpell = SpellSlot1.SpellChanneling("SoulDrain", Actions, Paralyzed, CurrentHealth);
		
		
		if (IncommingSpell[4].matches("[0-9]+")) {
		CurrentHealth = CurrentHealth + Integer.parseInt(IncommingSpell[4]);} // Heal player SoulDrain amount
		
		if (CurrentHealth > MaxHealth) { //if this player has more then the max health it sets health to max
			CurrentHealth = MaxHealth;}
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		return IncommingSpell;
	}
	
	/**
	 * Method that casts the first spell 'Fear' and exausts the approate actions
	 */
	public String[] SpellSlot2() {
		IncommingSpell = SpellSlot2.SpellChanneling("Fear", Actions, Paralyzed, CurrentHealth);
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		return IncommingSpell;
	}
	
	/**
	 * Method that casts the first spell 'CurseOfAThousandNeedles' and exausts the approate actions
	 */
	public String[] SpellSlot3() {
		IncommingSpell = SpellSlot3.SpellChanneling("CurseOfAThousandNeedles", Actions, Paralyzed, CurrentHealth);
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;} //sets the actions the spell uses to false(exausted)
		
		return IncommingSpell;
	}
	
}
