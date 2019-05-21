package Assignment3;

/**
 * Plague Knight Character Class
 */

public class EnemyPlagueKnight extends EnemyPlayer{
	
	public EnemyPlagueKnight() {
		SpellSlot1 = new PlagueSpells(); //set the spell slots to be looking at Plague spells
		SpellSlot2 = new PlagueSpells();
		SpellSlot3 = new PlagueSpells();
		
		Reward = SpellSlot1.RollOfTheDie(21) + 29; // when this enemy dies this is the ammount the play will gain in gold
		
		MaxHealth = 50;  
		CurrentHealth = MaxHealth;
	}
	
	/**
	 * Method that casts the first spell 'FesteringStrike' and exausts the approate actions
	 */
	public String[] SpellSlot1() {
		IncommingSpell = SpellSlot1.SpellChanneling("FesteringStrike", Actions, Paralyzed, CurrentHealth);
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;} //sets the actions the spell uses to false(exausted)
		
		return IncommingSpell;
	}
	
	/**
	 * Method that casts the Second spell 'RatPlague' and exausts the approate actions
	 */
	public String[] SpellSlot2() {
		IncommingSpell = SpellSlot2.SpellChanneling("RatPlague", Actions, Paralyzed, CurrentHealth);
		
		if (IncommingSpell[6].matches("[0-9]+")) {             //sets the actions the spell uses to false(exausted)
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}
		
		return IncommingSpell;
	}
	
	/**
	 * Method that casts the Third spell 'Pestilence' and exausts the approate actions
	 */
	public String[] SpellSlot3() {
		IncommingSpell = SpellSlot3.SpellChanneling("Pestilence", Actions, Paralyzed, CurrentHealth);
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		return IncommingSpell;
	}
	
}
