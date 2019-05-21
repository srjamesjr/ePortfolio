package Assignment3;

/**
 * Contains the 5 spells used by the HeroArcaneMage
 * 
 */

public class ArcaneSpells extends BaseSpell{
	private int TemparyDamage;
	
	public ArcaneSpells() {
		SpellDetails = new String[] {"", "", "", "", "", "", ""};  //Name, duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed
	}
	
	/**
	 * Spell Channeling method called in the SpellSlot method of the HeroArcaneMage
	 *   Used to call another method that shares a name with the spell in the respective spell slot
	 *   and set what action the spell uses to SpellDetails 
	 */
	@Override
	public String[] SpellChanneling(String SpellName, boolean[] Actions, boolean Paralyzed, int CurrentHealth) {
		TemparyDamage = 0;
		
		if (!Paralyzed) { //if your not paralyzed 
			if (CooldownTimer <= 0) { //if the spell is not on CooldownTimer
				
			    SpellDetails[3] = "Action is Exausted"; //if the following blocks of code don't overwrite SpellDetails it means that the player has no usable actions for this spell
			    
			    /**
			     * Spells that use Regular Actions
			     */
				if (Actions[0] == true) {
					if (SpellName.equals("MageFist")) {
						SpellDetails = MageFist();//calls the MageFist method below
						SpellDetails[6] = Integer.toString(0);
					}
					if (SpellName.equals("ArcaneMissles")) {
						SpellDetails = ArcaneMissles();//calls the ArcaneMissles method below
						SpellDetails[6] = Integer.toString(0);
					}
				}
				
				 /**
			     * Spells that use Quick Actions
			     */
				for(int i = 1; i < 4; i++) { //for loop to cycle the 3 quick actions 
					if (Actions[i] == true) {
						if (SpellName.equals("Blink")) {
							SpellDetails = Blink(); //calls the Blink method below
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						if (SpellName.equals("ArcanePower")) {
							SpellDetails = ArcanePower();//calls the ArcanePower method below
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						if (SpellName.equals("Polymorph")) {
							SpellDetails = Polymorph();//calls the Polymorph method below
							SpellDetails[6] = Integer.toString(i);
							break;
						}
				    }
				}
			} else {SpellDetails[3] = "on Cooldown"; } //if the spell is on CooldownTimer
		} else {SpellDetails[3] = "Paralyzed"; }//if you are paralyzed
		
		return SpellDetails; 
		
	}
	
	
	
	/**
     * Methods to set Spells details and CooldownTimer
     */
	private String[] Polymorph() {
		SpellDetails = new String[] {"Polymorph", "1", "2", "Polymorph", "", "Enemy", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] MageFist() {
		SpellDetails = new String[] {"MageFist", "0", "1", "Damage", "6", "Enemy", ""}; 
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] Blink() {
		SpellDetails = new String[] {"Blink", "1", "2", "Invulnerable", "", "Self", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
	
		return SpellDetails;
	}
	
	private String[] ArcaneMissles() {
		SpellDetails = new String[] {"ArcaneMissles", "0", "1", "Damage", "", "Enemy", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		TemparyDamage = RollOfTheDie(2) + RollOfTheDie(4) + RollOfTheDie(6);// damage is equal to 3 "random" numbers
 		SpellDetails[4] = Integer.toString(TemparyDamage);
		
		return SpellDetails;
	}
	
	private String[] ArcanePower() {
		SpellDetails = new String[] {"ArcanePower", "1", "3", "DoubleDamage", "", "Self", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
				
		return SpellDetails;
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

