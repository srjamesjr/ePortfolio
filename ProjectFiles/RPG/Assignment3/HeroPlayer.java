package Assignment3;

import java.util.ArrayList;

/**
 * Parent Class to all Hero Players
 */

public abstract class HeroPlayer extends BasePlayer {
	
	BaseWeapon CurrentWeapon; //Players can have weapons
	
	protected int Gold;    //Players hold
	
	protected ArrayList<String> SpellBook = new ArrayList<>(); //Spellbook holds the spells the player knowns how to cast, used in the SpellSlot methods in the childs
	
	public HeroPlayer() {
		}
	
	public void SetCurrentWeapon(BaseWeapon NewWeapon) { //Weapon setter
		CurrentWeapon = NewWeapon;
		
	}
	public BaseWeapon GetCurrentWeapon() { //weapon Getter
		return CurrentWeapon;
		
	}
	
	public void SetGold(int Gold) { //Setter
		this.Gold = Gold;
	}
	
	public int GetGold() { // Getter
		return Gold;
	}
	
	public void AddSpellBook(String purchasedSpell) {  //(Setter) add spell to the spell book
		SpellBook.add(purchasedSpell);
	}
	
	public void RemoveSpellBook(String index) { //(Setter) Remove a spell from the spell book
		if (SpellBook.contains(index)) {
		SpellBook.remove(index);
		}
	}
	
	public ArrayList<String> GetSpellBook() { //Getter
		return SpellBook;
	}
	
	/**
	 * This method is for the SpellSlots to double damage if you have the DoubleDamage Status effect
	 */
	protected void CanDouble() {
		if(IncommingSpell[3].equals("Damage")) { //if the spell is dealing damage
			if (StatusEffects.get("DoubleDamage") != null) { //if you have the doubledamage status effect
				if (StatusEffects.get("DoubleDamage") > 0) { //if the status effect is active
					
					IncommingSpell[4] = Integer.toString(Integer.parseInt(IncommingSpell[4]) + Integer.parseInt(IncommingSpell[4])); //the damage of incomming spell is equal to it's self twice
				}
			}
		}
	}
	
	
	public abstract String[] WeaponAttack(); //abstract method for attacking with a weapon

}
