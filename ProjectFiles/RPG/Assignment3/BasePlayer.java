package Assignment3;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Parent class for all Players (User and NPC)
 */
public abstract class BasePlayer {

	protected int MaxHealth = 0;
	protected int CurrentHealth = MaxHealth;
	
	protected boolean Paralyzed = false;
	protected boolean Invulnerable = false;
	protected boolean HaveBasicAttacked = false;
	protected boolean[] Actions = {true, true, true, true}; // //regular, quick, quick, quick
	protected Map<String,Integer> StatusEffects = new TreeMap<String,Integer>();
	protected String[] IncommingSpell = new String[7];//Name, duration, CooldownTime, effectID, effectVALUE, Target, ActionsUsed
	
	protected BaseSpell SpellSlot1;
	protected BaseSpell SpellSlot2;
	protected BaseSpell SpellSlot3;
	

	/**
	 * Method to check if player is dead
	 */
	public boolean AmDead() {
		if (CurrentHealth <= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean[] GetActions() { //Getter for Actions
		return Actions;
	}
	
	public Map<String,Integer> GetStatus() { //Getter for Statuseffects
		return StatusEffects;
	}
	public int GetHealth() {  //Getter for Current Health
		return CurrentHealth;
	}
	
	/**
	 * Method that takes in SpellDetails to apply the effect of the spell to this player
	 */
	public void GotHitWith(String[] IncommingSpell) {
		
		if(!Invulnerable) { //if you not invulnerable 
			
			/**
			 * Hurtfull effecting Spells
			 */
			if (IncommingSpell[3].equalsIgnoreCase("Damage")) {
				CurrentHealth = CurrentHealth - Integer.parseInt(IncommingSpell[4]);
				
			}else if (IncommingSpell[3].equalsIgnoreCase("Polymorph")) {
				StatusEffects.put("Polymorph", Integer.parseInt(IncommingSpell[1]));
				Paralyzed = true;
				
			}else if (IncommingSpell[3].equalsIgnoreCase("Fear")) {
				StatusEffects.put("Fear", Integer.parseInt(IncommingSpell[1]));
				Paralyzed = true;
				
			}else if (IncommingSpell[3].equalsIgnoreCase("CurseOfAThousandNeedles")) {
				StatusEffects.put("CurseOfAThousandNeedles", Integer.parseInt(IncommingSpell[1]));
				
			}else if (IncommingSpell[3].equalsIgnoreCase("Pestilence")) {
				StatusEffects.put("Pestilence", Integer.parseInt(IncommingSpell[1]));
				
			}else if (IncommingSpell[3].equalsIgnoreCase("ExaustQuickAction")) {
				Actions[3] = true;
				
			}
		}//if(!Invulnerable) end so the helpfull can still get applied
		/**
		 * Helpfull effecting Spells ()
		 */
		
		if (IncommingSpell[3].equalsIgnoreCase("Heal")) {
			CurrentHealth = CurrentHealth + Integer.parseInt(IncommingSpell[4]);
			if (CurrentHealth > MaxHealth) {
				CurrentHealth = MaxHealth;
			}	
		}else if (IncommingSpell[3].equalsIgnoreCase("Invulnerable")) {
			StatusEffects.put("Invulnerable", Integer.parseInt(IncommingSpell[1]));
			Invulnerable = true;
			
		}else if (IncommingSpell[3].equalsIgnoreCase("RestoreAllAction")) {
			this.Actions[0] = true;
			this.Actions[1] = true;
			this.Actions[2] = true;
			this.Actions[3] = true;
			
		}else if (IncommingSpell[3].equalsIgnoreCase("DoubleDamage")) {
			StatusEffects.put("DoubleDamage", Integer.parseInt(IncommingSpell[1]));
		
		}
		
	}
	
	/**
	 * Method for Cooldown and StatusEffects to have them count down and no longer active when no time left
	 * 
	 */
	public void StartTurn() {
		
		/**
		 * Cooldown Countdown
		 */
		if (SpellSlot1.GetCooldownTimer() > 0) {
		SpellSlot1.SubtractCooldownTimer(1);
		} if (SpellSlot2.GetCooldownTimer() > 0) {
		SpellSlot2.SubtractCooldownTimer(1);
		} if (SpellSlot3.GetCooldownTimer() > 0) {
		SpellSlot3.SubtractCooldownTimer(1);
		}
		
		Actions[0] = true; //restore regular action
				
		/**
		 * Status Effect Countdown
		 */
		if (StatusEffects.get("Polymorph") != null) {
			if (StatusEffects.get("Polymorph") > 0) {
					Paralyzed = true;
					StatusEffects.put("Polymorph", StatusEffects.get("Polymorph") - 1);
	
		    }else if (StatusEffects.get("Polymorph") <= 0) {
					Paralyzed = false;
					StatusEffects.remove("Polymorph");
				}
		}
		if (StatusEffects.get("Fear") != null) {
			if (StatusEffects.get("Fear") > 0) {
					Paralyzed = true;
					StatusEffects.put("Fear", StatusEffects.get("Fear") - 1);
	
		    }else if (StatusEffects.get("Fear") <= 0) {
					Paralyzed = false;
					StatusEffects.remove("Fear");
				}
		}
		if (StatusEffects.get("DoubleDamage") != null) {
			if (StatusEffects.get("DoubleDamage") > 0) {
					StatusEffects.put("DoubleDamage", StatusEffects.get("DoubleDamage") - 1);
					
	
		    }else if (StatusEffects.get("DoubleDamage") <= 0) {
					StatusEffects.remove("DoubleDamage");
				}
		}
		if (StatusEffects.get("Invulnerable") != null) {
			if (StatusEffects.get("Invulnerable") > 0) {
					Invulnerable = true;
					StatusEffects.put("Invulnerable", StatusEffects.get("Invulnerable") - 1);
					
	
		    }else if (StatusEffects.get("Invulnerable") <= 0) {
		    		Invulnerable = false;
					StatusEffects.remove("Invulnerable");
					
				}
		}
		if (StatusEffects.get("CurseOfAThousandNeedles") != null) {
			if (StatusEffects.get("CurseOfAThousandNeedles") > 0) {
					StatusEffects.put("CurseOfAThousandNeedles", StatusEffects.get("CurseOfAThousandNeedles") - 1);
					CurrentHealth = CurrentHealth - 1;
					
		    }else if (StatusEffects.get("CurseOfAThousandNeedles") <= 0) {
					StatusEffects.remove("CurseOfAThousandNeedles");
				}
		}
		if (StatusEffects.get("Pestilence") != null) {
			if (StatusEffects.get("Pestilence") > 0) {
					StatusEffects.put("Pestilence", StatusEffects.get("Pestilence") - 1);
					CurrentHealth = CurrentHealth - 2;
					
		    }else if (StatusEffects.get("Pestilence") <= 0) {
					StatusEffects.remove("Pestilence");
				}
		}
	}
	
	/**
	 * Method the resets cooldowns, actions and Health for when no longer in combat 
	 */
	public void EndCombat() {
		
		if (SpellSlot1.GetCooldownTimer() > 0) {
			SpellSlot1.SubtractCooldownTimer(SpellSlot1.GetCooldownTimer());
			} 
		if (SpellSlot2.GetCooldownTimer() > 0) {
			SpellSlot2.SubtractCooldownTimer(SpellSlot1.GetCooldownTimer());
			} 
		if (SpellSlot3.GetCooldownTimer() > 0) {
			SpellSlot3.SubtractCooldownTimer(SpellSlot1.GetCooldownTimer());
			}
			
		this.Actions[0] = true; //restore regular action
		this.Actions[1] = true; //restore quick action
		this.Actions[2] = true; //restore quick action
		this.Actions[3] = true; //restore quick action
			
		Paralyzed = false;
		Invulnerable = false;
		HaveBasicAttacked = false;
		CurrentHealth = MaxHealth;
		
		for (Entry<String, Integer> entry : StatusEffects.entrySet()) { //wipes all staus effects
			StatusEffects.put(entry.getKey(), 0);
		}
		
	}
	
	/**
	 * Abstract methods for Spells
	 */
	public abstract String[] SpellSlot1();
	public abstract String[] SpellSlot2();
	public abstract String[] SpellSlot3();
	
}
