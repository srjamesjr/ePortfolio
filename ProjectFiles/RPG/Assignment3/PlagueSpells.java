package Assignment3;

public class PlagueSpells extends BaseSpell{
	private int TemparyDamage;
	
	public PlagueSpells() {
		SpellDetails = new String[] {"", "", "", "", "", "", ""};  //Name, duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed
	}
	
	/**
	 * Spell Channeling method called in the SpellSlot method of the Plague Knight
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
					if (SpellName.equals("FesteringStrike")) {
						SpellDetails = FesteringStrike();
						SpellDetails[6] = Integer.toString(0);
					}
					if (SpellName.equals("RatPlague")) {
						SpellDetails = RatPlague();
						SpellDetails[6] = Integer.toString(0);
					}
				}
				
				/**
			     * Spells that use Quick Actions
			     */
				for(int i = 1; i < 4; i++) {
					if (Actions[i] == true) { //for loop to cycle the 3 quick actions 
						if (SpellName.equals("Pestilence")) {
							SpellDetails = Pestilence();
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						
				    }
				}
			} else {SpellDetails[3] = "on Cooldown"; } //if the spell is on CooldownTimer
		} else {SpellDetails[3] = "Paralyzed"; } //if you are paralyzed
		
		return SpellDetails;
		
	}
	
	
	
	/**
     * Methods to set Spells details and CooldownTimer
     */
	private String[] FesteringStrike() {
		SpellDetails = new String[] {"FesteringStrike", "0", "1", "Damage", "3", "Enemy", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] RatPlague() {
		SpellDetails = new String[] {"RatPlague", "0", "1", "Damage", "", "Enemy", ""}; 
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		TemparyDamage = RollOfTheDie(3) + RollOfTheDie(3) + RollOfTheDie(3); // damage is equal to 3 "random" numbers
		SpellDetails[4] = Integer.toString(TemparyDamage);
		
		return SpellDetails;
	}
	
	private String[] Pestilence() {
		SpellDetails = new String[] {"Pestilence", "5", "2", "Pestilence", "3", "Enemy", ""};
		
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
	
		return SpellDetails;
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

