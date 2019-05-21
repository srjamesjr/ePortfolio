package Assignment3;

/**
 * The Sword of Frost and Fire
 * Has 3 abilitys that happen in one swing
 */
public class SwordOfFrostAndFire extends BaseWeapon {
	
	public SwordOfFrostAndFire(String Name,String Duration, String CooldownTimerTime, String effectID, String effectVALUE, String Target, String ActionsUsed) {
		
		WeaponDetails = new String[] {Name, Duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed};
		
		WeaponEffects = new String[][] {{"Freeze", "1", "0", "Fear",     "1", "Enemy", ""},
										{"Burn", "2", "0", "Pesilence","3", "Enemy", ""},  
										{"Sword Of Frost and Fire", "0", "0", "Damage",   "2", "Enemy",  ""}};  //3 Abilitys that will get cast when weapon is attacked with
	}
	@Override
	public String WeaponName() {//getter for Weapon name
		return "SwordOfFrostAndFire";
	}
}
