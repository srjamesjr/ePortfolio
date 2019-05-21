package Assignment3;

import java.util.Arrays;

public class HolySpells extends BaseSpell{
	private int TemparyDamage;
	
	public HolySpells() {
		SpellDetails = new String[] {"", "", "", "", "", "", ""};  //Name, duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed
	}
	
	/**
	 * Spell Channeling method called in the SpellSlot method of the HeroPaladin
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
					if (SpellName.equals("BoomerangShield")) {
						SpellDetails = BoomerangShield();
						SpellDetails[6] = Integer.toString(0);
					}
					if (SpellName.equals("HammerOfRighteousness")) {
						SpellDetails = HammerOfRighteousness(CurrentHealth);
						SpellDetails[6] = Integer.toString(0);
					}
				}

				/**
			     * Spells that use Quick Actions
			     */
				for(int i = 1; i < 4; i++) {
					if (Actions[i] == true) { //for loop to cycle the 3 quick actions 
						if (SpellName.equals("RadiantWard")) {
							SpellDetails = RadiantWard();
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						if (SpellName.equals("DivineFavor")) {
							SpellDetails = DivineFavor();
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						if (SpellName.equals("Aegis")) {
							SpellDetails = Aegis();
							SpellDetails[6] = Integer.toString(i);
							break;
						}
				    }
				}
			} else {SpellDetails[3] = "on Cooldown"; }//if the spell is on CooldownTimer
		} else {SpellDetails[3] = "Paralyzed"; }//if you are paralyzed
		
		return SpellDetails;
		
	}
	
	
	
	/**
     * Methods to set Spells details and CooldownTimer
     */
	private String[] BoomerangShield() {
		SpellDetails = new String[] {"BoomerangShield", "0", "1", "Damage", "6", "Enemy", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] HammerOfRighteousness(int CurrentHealth) {
		SpellDetails = new String[] {"HammerOfRighteousness", "0", "1", "Damage", "", "Enemy", ""}; 
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		TemparyDamage = (34 - CurrentHealth)/2;  //Deal Damage equal to half your Health
		SpellDetails[4] = Integer.toString(TemparyDamage);
		
		return SpellDetails;
	}
	
	private String[] RadiantWard() {
		SpellDetails = new String[] {"RadiantWard", "0", "2", "Heal", "", "Self", ""};
		
		TemparyDamage = RollOfTheDie(6) + 2;            //Heal for a random number from 1-6 plus 2
		SpellDetails[4] = Integer.toString(TemparyDamage);
		
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
	
		return SpellDetails;
	}
	
	private String[] DivineFavor() {
		SpellDetails = new String[] {"DivineFavor", "0", "2", "RestoreAllAction", "", "Self", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] Aegis() {
		SpellDetails = new String[] {"Aegis", "1", "2", "Invulnerable", "", "Self", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
				
		return SpellDetails;
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

