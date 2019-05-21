/**
 * Player vs player games are traditionally played using dice. Each player has a certain number of points at the start and the loser decided by who loses all of their health points first.
 *  Both players roll (one as attacker the other defender) each turn. Loss of points occurs when the attacker rolls higher than the defender. 
 *  In the case of a tie or the defender rolling higher, then no points are lost.
 *   Attributes of the character such as strength and objects they have such as weapons may modify the respective attack and defense of the players. 
 *   The theme you select for your game is up to you and may include fantasy, science fiction, cops vs robbers, or even whimsical ones such as ‘plants vs zombies’.
 * Specifications:
 *
 *
 * You have scope within these specifications in order to encourage creativity and interest; 
 * however, I would like to see you demonstrate at least the following to show your competency in OOP and Java:
 *
 * Your game will allow the user to outfit at least one character with gear and allow two characters to engage in combat. It will provide a simple play by play of the action (e.g. “Knight hits dragon for 10 points”) and report the winner of the match.
 * 
 * Your game should have examples of both inheritance and aggregation
 * 
 * It should contain several different classes (excluding GUI classes and driver).
 * 
 * This is to be a “text-based game” in that all combat is text rather than game characters moving around a board. \
 * You may not use a System based user interface (i.e. Scanner, System.print or JOptionPanes. GUI will be used to select combatants, equip characters, 
 * and for the text to be written to.
 *
 * Please see the Rubric below for any other specification information.
 */


package Assignment3;

import java.awt.EventQueue;

/**
 * Main Class that launches the window class
 */

public class PlayervsPlayerMain {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayervsPlayerWindow window = new PlayervsPlayerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Fatal error has occured, likely a mismatch image file");
					e.printStackTrace();
				}
			}
		});
	}
}
