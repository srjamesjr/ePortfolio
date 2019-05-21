package Assignment3;

/**
 * The Sword of Fighting and Friendship
 * Has 3 abilitys that happen in one swing
 */
public class SwordOfFightingAndFriendship extends BaseWeapon {
	
	public SwordOfFightingAndFriendship(String Name,String Duration, String CooldownTimerTime, String effectID, String effectVALUE, String Target, String ActionsUsed) {
		
		WeaponDetails = new String[] {Name, Duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed};
		
		WeaponEffects = new String[][] {{"Double Damage", "0", "0", "DoubleDamage","0", "Self", ""},
										{"Invulnerablility", "0", "0", "Invulnerable","0", "Self", ""}, 
										{"Sword Of Fight And Friendship", "0", "0", "Damage",      "2", "Enemy",  ""}};  //3 Abilitys that will get cast when weapon is attacked with
	}
	@Override
	public String WeaponName() {//getter for Weapon name
		return "SwordOfFightAndFriendship";
	}
}
