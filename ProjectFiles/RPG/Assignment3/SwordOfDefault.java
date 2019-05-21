package Assignment3;

/**
 * Default Sword before you buy one
 */
public class SwordOfDefault extends BaseWeapon {
	
	public SwordOfDefault() {
		WeaponDetails = new String[] {"SwordOfDefault", "0", "0", "Damage", "5", "Enemy", ""}; 
		

	}
	@Override
	public String WeaponName() {//getter for Weapon name
		return "Wood";
	}
}
