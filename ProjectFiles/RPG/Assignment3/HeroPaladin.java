package Assignment3;

/**
 * Paladin Character Class
 */

public class HeroPaladin extends HeroPlayer{
	
	//KnownSpells = new ArcaneSpells;
	
	public HeroPaladin() {
		SpellSlot1 = new HolySpells(); //sets the spell slots to be looking at Holy Spells
		SpellSlot2 = new HolySpells();
		SpellSlot3 = new HolySpells();
		
		MaxHealth = 34;
		CurrentHealth = MaxHealth;
		
	}
	
	
	/**
	 * This method casts the first spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot1() {
		IncommingSpell = SpellSlot1.SpellChanneling(SpellBook.get(0), Actions, Paralyzed, CurrentHealth);//sets 'IncommingSpell' to the value of the SpellChanneling Method 
																										// of the spell name in the first spot in the spell book
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		CanDouble();// method so that if you have the doubledamage status effect your damage will double
		
		
		return IncommingSpell;
	}
	
	/**
	 * This method casts the second spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot2() {
		IncommingSpell = SpellSlot2.SpellChanneling(SpellBook.get(1), Actions, Paralyzed, CurrentHealth);//sets 'IncommingSpell' to the value of the SpellChanneling Method 
		  																								// of the spell name in the first spot in the spell book
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		CanDouble();// method so that if you have the doubledamage status effect your damage will double
		
		
		return IncommingSpell;
	}
	
	/**
	 * This method casts the Third spell in the spell book and exausts the approate actions
	 */
	public String[] SpellSlot3() {
		IncommingSpell = SpellSlot3.SpellChanneling(SpellBook.get(2), Actions, Paralyzed, CurrentHealth);//sets 'IncommingSpell' to the value of the SpellChanneling Method 
																										// of the spell name in the first spot in the spell book
		
		if (IncommingSpell[6].matches("[0-9]+")) {
		Actions[Integer.parseInt(IncommingSpell[6])] = false;}//sets the actions the spell uses to false(exausted)
		
		CanDouble();// method so that if you have the doubledamage status effect your damage will double
		
		
		return IncommingSpell;
	}

	
	/**
	 * Method that Attacks with the Weapon you are holding
	 */
	@Override
	public String[] WeaponAttack() {
		
		if (!HaveBasicAttacked) {
			HaveBasicAttacked = true;//Prevents you from attacking more then once with the weapon (per combat)
			HaveBasicAttacked = true;      //
			
			IncommingSpell = CurrentWeapon.WeaponDetails;// sets IncommingSpell to the Weapon details in the same way spells work
			
			Actions[0] = false;
			
			CanDouble();// method so that if you have the doubledamage status effect your damage will double
			
		} else {
			IncommingSpell[3] = "on CoolDown";
		}
		return IncommingSpell;
	}
	
}
