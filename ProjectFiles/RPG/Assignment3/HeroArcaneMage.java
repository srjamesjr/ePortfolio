package Assignment3;

/**
 * Mage Character Class
 */

public class HeroArcaneMage extends HeroPlayer{
	
	//KnownSpells = new ArcaneSpells;
	
	public HeroArcaneMage() {
		MaxHealth = 30;
		CurrentHealth = MaxHealth;

		SpellSlot1 = new ArcaneSpells(); //set the spell slots to be looking at arcane spells
		SpellSlot2 = new ArcaneSpells();
		SpellSlot3 = new ArcaneSpells();
		
	}

	/**
	 * Method that casts the first spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot1() {
		IncommingSpell = SpellSlot1.SpellChanneling(SpellBook.get(0), Actions, Paralyzed, CurrentHealth); //sets 'IncommingSpell' to the value of the SpellChanneling Method 
																										  // of the spell name in the first spot in the spell book
		if (IncommingSpell[6].matches("[0-9]+")) {//sets the actions the spell uses to false(exhausted)
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}
		
		CanDouble(); // method so that if you have the double damage status effect your damage will double
		
		return IncommingSpell;
	}
	
	/**
	 * Method that casts the Second spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot2() {
		IncommingSpell = SpellSlot2.SpellChanneling(SpellBook.get(1), Actions, Paralyzed, CurrentHealth);//sets 'IncommingSpell' to the value of the SpellChanneling Method 
		  																						 		// of the spell name in the Second spot in the spell book
		if (IncommingSpell[6].matches("[0-9]+")) {//sets the actions the spell uses to false(exhausted)
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}
		
		CanDouble(); // method so that if you have the double damage status effect your damage will double
		
		return IncommingSpell;
	}
	/**
	 * Method that casts the Third spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot3() {
		IncommingSpell = SpellSlot3.SpellChanneling(SpellBook.get(2), Actions, Paralyzed, CurrentHealth);//sets 'IncommingSpell' to the value of the SpellChanneling Method 
			                                                                                             // of the spell name in the Second spot in the spell book
		if (IncommingSpell[6].matches("[0-9]+")) {             //sets the actions the spell uses to false(exhausted)
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}
		
		CanDouble(); // method so that if you have the double damage status effect your damage will double
		
		return IncommingSpell;
	}
	
	/**
	 * Method that Attacks with the Weapon you are holding
	 */
	@Override
	public String[] WeaponAttack() {
		
		if (!HaveBasicAttacked) {          //Prevents you from attacking more then once with the weapon (per combat)
			HaveBasicAttacked = true;      //
			
			
			IncommingSpell = CurrentWeapon.WeaponDetails; // sets IncommingSpell to the Weapon details in the same way spells work
			
			Actions[0] = false;
			
			CanDouble();// method so that if you have the doubledamage status effect your damage will double
			
		} else {
			IncommingSpell[3] = "on CoolDown";
		}
		return IncommingSpell;
	}
	
}
