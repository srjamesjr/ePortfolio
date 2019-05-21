package Assignment3;

/**
 * WarlockSpells Class
 */
public class WarlockSpells extends BaseSpell{
	private int TemparyDamage;
	
	public WarlockSpells() {
		SpellDetails = new String[] {"", "", "", "", "", "", ""};  //Name, duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed
	}
	
	/**
	 * Spell Channeling method called in the SpellSlot method of the EnemyWarlock
	 *   Used to call another method that shares a name with the spell in the respective spell slot
	 *   and set what action the spell uses to SpellDetails 
	 */
	@Override
	public String[] SpellChanneling(String SpellName, boolean[] Actions, boolean Paralyzed, int CurrentHealth) {
		TemparyDamage = 0;
		if (!Paralyzed) {//if your not paralyzed
			if (CooldownTimer <= 0) {//if the spell is not on CooldownTimer
				
				 SpellDetails[3] = "Action is Exausted"; //if the following blocks of code don't overwrite SpellDetails it means that the player has no usable actions for this spell
				
				 /**
				   * Spells that use Regular Actions
				   */
				if (Actions[0] == true) {
					if (SpellName.equals("SoulDrain")) {
						SpellDetails = SoulDrain();
						SpellDetails[6] = Integer.toString(0);
					}
				}
				
				/**
			     * Spells that use Quick Actions
			     */
				for(int i = 1; i < 4; i++) {//for loop to cycle the 3 quick actions 
					if (Actions[i] == true) {
						if (SpellName.equals("Fear")) {
							SpellDetails = Fear();
							SpellDetails[6] = Integer.toString(i);
							break;
						}
						if (SpellName.equals("CurseOfAThousandNeedles")) {
							SpellDetails = CurseOfAThousandNeedles();
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
	private String[] SoulDrain() {
		SpellDetails = new String[] {"SoulDrain", "0", "1", "Damage/Heal", "5", "Enemy/Self", ""};
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] Fear() {
		SpellDetails = new String[] {"Fear", "2", "1", "Fear", "", "Enemy", ""}; 
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
		
		return SpellDetails;
	}
	
	private String[] CurseOfAThousandNeedles() {
		SpellDetails = new String[] {"CurseOfAThousandNeedles", "6", "1", "CurseOfAThousandNeedles", "1", "Enemy", ""};
		
		CooldownTimer = Integer.parseInt(SpellDetails[2]);
	
		return SpellDetails;
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	

