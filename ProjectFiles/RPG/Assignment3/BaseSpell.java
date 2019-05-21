package Assignment3;

import java.util.Random;

/**
 * Parent class for all Spells 
 */
public abstract class BaseSpell {
	protected int CooldownTimer = 0;
	protected String[] SpellDetails = new String[6]; //Name, duration, CooldownTime, CastCost, effectID, effectVALUE, Target, ActionsUsed
	
	private Random rng = new Random();
	
	/**
	 * Abstract method for getting the details of a cast spell 
	 */
	public abstract String[] SpellChanneling(String SpellName, boolean[] Actions, boolean Paralyzed, int currentHealth);
	
	
	public void SubtractCooldownTimer(int TimePass) { //setter, decrease CooldownTimer
		CooldownTimer = CooldownTimer - TimePass;
	}
	
	public int GetCooldownTimer() { //getter
		return CooldownTimer;
	}
	
	/**
     * Method that spells can use if they need a random number
     */
	public int RollOfTheDie(int Max) {
		int Output = rng.nextInt(Max) + 1;
		return Output;
	}
}
