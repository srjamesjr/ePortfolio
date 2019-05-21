package Assignment3;

/**
 * The Sword of Feast and Famine
 * Has 3 abilitys that happen in one swing
 */
public class SwordOfFeastAndFamine extends BaseWeapon {
	
	public SwordOfFeastAndFamine(String Name,String Duration, String CooldownTimerTime, String effectID, String effectVALUE, String Target, String ActionsUsed) {
		
		WeaponDetails = new String[] {Name, Duration, CooldownTimerTime, effectID, effectVALUE, Target, ActionsUsed};
		
		WeaponEffects = new String[][] {{"Sword Of Feast And Famine", "0", "0", "Damage",            "2", "Enemy", ""}, //3 Abilitys that will get cast when weapon is attacked with
										{"Exaust Quick Actions", "0", "0", "ExaustQuickAction", "2", "Enemy", ""}, 
										{"Restore All Actons", "0", "0", "RestoreAllAction",     "2", "Self",  ""}};
	}

	@Override
	public String WeaponName() { //getter for Weapon name
		return "SwordOfFeastAndFamine";
	}
	
}
