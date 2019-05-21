package Assignment3;

import java.util.Random;

/**
 * Parent class to all weapons
 */

public abstract class BaseWeapon {
	
	private Random rng = new Random();
	
	/**
     * Method that Weapons can use if they need a random number
     */
	protected int RollOfTheDie(int Max) {
		int Output = rng.nextInt(Max) + 1;
		return Output;
	}
	
	protected String[] WeaponDetails = new String[] {"", "", "", "", "", "", ""};//Name, duration, CooldownTime, effectID, effectVALUE, Target, ActionsUsed
	
	protected String[][] WeaponEffects = new String[][] {{"", "", "", "", "", "", ""},// for weapons that have multi - effects
														 {"", "", "", "", "", "", ""}, 
														 {"", "", "", "", "", "", ""}}; //Name, duration, CooldownTime, effectID, effectVALUE, Target, ActionsUsed
	
	/**
	* Method so the outside world can see what weapons you have 
	*/
	public abstract String WeaponName();
}
