package Assignment3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;

import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.ScrollPaneConstants;

public class PlayervsPlayerWindow {

	
	/**
	 * Initalizing many GUI j-frames
	 */
	 public JFrame frame;
	private JPanel StartWindow;
	private JPanel ClassSelection;
	private JPanel SpellSelection;
	private JPanel WeaponSelection;
	private JPanel Battlefield;
	private JLabel StartButton;
	private JLabel StartBackground;
	private JLabel label;
	        JPanel TheGame;
	private JLabel ClassBackground;
	private JLabel Mage;
	private JLabel Paladin;
	private JLabel SpellBackground;
	private JLabel Spell1;
	private JLabel Spell2;
	private JLabel Spell3;
	private JLabel Spell4;
	private JLabel Spell5;
	private JLabel SpellText1;
	private JLabel SpellText2;
	private JLabel SpellText3;
	private JLabel SpellText4;
	private JLabel SpellText5;
	private JLabel FeastAndFamine;
	private JLabel FeastText;
	private JLabel WeaponBackground;
	private JLabel FrostAndFire;
	private JLabel FightingText;
	private JLabel BasicAttack;
	private JLabel SpellSlotFirst;
	private JLabel SpellSlotThird;
	private JLabel SpellSlotSecond;
	private JLabel AmountGold;
	private JLabel MonsterName;
	        JProgressBar MonsterHealth;
	        JProgressBar PlayerHealth;
	private JButton SummonMonster;
	private JButton ToShop;
	private JLabel PlayerName;
	private JLabel TheWordGold;
	private JLabel MonsterPic;
	        JLabel Action1;
	        JLabel Action2;
	        JLabel Action3;
	        JLabel Action0;
    private JPanel EndGame;
    private JLabel YouDied;
    private JLabel HavePestilence;
    private JLabel HaveNeedles;
    private JLabel HaveDouble;
    private JLabel HaveInvulnerable;
    private JLabel HaveParalyze;
    private JLabel FireText;
	private JLabel FightingAndFriendShip;
	private JButton WeaponBack;	
	private JTextArea CombatLog;
	private JScrollPane Scroll;
	
	/**
	 * Initalizing variables
	 */
	private HeroPlayer Player1 = null;
	private String IncommingSpell[] = new String[6];
	private String Class = "";
	private int TempCount = 0;
	private int TempCount2 = 0;
	private boolean SuccessfullHit = false;
	private BaseWeapon NewWeapon;
	private EnemyPlayer Player2 = null;
	private Random rng = new Random();
	private boolean IsEnemy = false;
	


//OnStart
	public PlayervsPlayerWindow() {
		initialize();
	}

	/**
	 * Setters for Icon Images
	 */
	private void SetStartButtonIcon(ImageIcon picture) {
		this.StartButton.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetSpell1Icon(ImageIcon picture) {
		this.Spell1.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetSpell2Icon(ImageIcon picture) {
		this.Spell2.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetSpell3Icon(ImageIcon picture) {
		this.Spell3.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetSpell4Icon(ImageIcon picture) {
		this.Spell4.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetSpell5Icon(ImageIcon picture) {
		this.Spell5.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	private void SetMonsterPicIcon(ImageIcon picture) {
		this.MonsterPic.setIcon(picture);
		TheGame.repaint();
		TheGame.revalidate();
	}
	
	/**
	 * Changes the panel
	 */
	private void ChangeWindow(JPanel pane) {
		TheGame.removeAll();
		TheGame.add(pane);
		TheGame.repaint();
		TheGame.revalidate();
	}
	
	/**
	 * Setup for when the panel changes to the battlefield
	 */
	private void EnterTheBattlefield() {
		TheGame.removeAll();
		TheGame.add(Battlefield);
		TheGame.revalidate();
		TheGame.repaint();
		
		
		NewWeapon = new SwordOfDefault(); //setting a default weapon to the play until they can buy a better one
		Player1.SetCurrentWeapon(NewWeapon);
		
		PlayerHealth.setMaximum(Player1.GetHealth());
		SpellSlotFirst.setIcon(SpellPickerPicture(Player1.GetSpellBook().get(0)));
		SpellSlotSecond.setIcon(SpellPickerPicture(Player1.GetSpellBook().get(1))); //sets the spellslots icons
		SpellSlotThird.setIcon(SpellPickerPicture(Player1.GetSpellBook().get(2)));
		
	}
	
	/**
	 * Handles when the player attacks(Casts a spell)
	 * -if the spell can hit and who it hit
	 * -outputs to the combat log
	 */
	private void Attack(String[] IncommingSpell) {
		
			if (IncommingSpell[3].equals("Paralyzed")) { //if your paralyzed
				AddCombatLog("You Can Not Cast You Are Paralyzed");
				SuccessfullHit = true; //count as a hit to skip your turn
				
			}else if (IncommingSpell[3].equals("on Cooldown")) {//if the spell is on cooldown
				SuccessfullHit = false;
				AddCombatLog("That Spell is on Cooldown");
				
			}else if (IncommingSpell[3].equals("Action is Exausted")) {//if the action the spell requires is exausted
				SuccessfullHit = false;
				AddCombatLog("The Actions that spell cost is Exausted");
				
			}else {//if the spell can hit
				SuccessfullHit = true;
				if (IncommingSpell[5].equals("Self")) {//if there is a Self properity at the target flag you hit yourself with the spell
					Player1.GotHitWith(IncommingSpell);
					AddCombatLog("You Cast " + IncommingSpell[0] + " on Yourself");
					
				}else if (IncommingSpell[5].equals("Enemy")) { //if there is a Enemy properity at the target flag you hit the enemy with the spell
					Player2.GotHitWith(IncommingSpell);
					if (IncommingSpell[3].equals("Damage")) {//if it's damage say how much
						AddCombatLog("You hit the target dealing " + IncommingSpell[4] + " Damage");
					}else {//if not damage say the spell cast
						AddCombatLog("You Cast " + IncommingSpell[0] + " on the target");
					}
				}
			}
	}
	
	/**
	 * Test to see if the enemy or the player has died
	 */
	private void IsAnyoneDed() {
		
			if (Player1.AmDead()) {//if the player has died take them to the end screen
				ChangeWindow(EndGame);
			}
			if (Player2 != null) {
				if (MonsterName.getText().equals("Warlock")) {
					if (Player2.AmDead()) {//if the monster is a warlock and he dies
						SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/WarlockDead.png"))); //set picture to dead warlock
						Player1.EndCombat(); //end combat for the player (Cleanup)
						Player1.SetGold(Player1.GetGold() + Player2.GetReward()); //give the player the gold reward
						IsEnemy = false;
					}else {
						SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Warlock.png")));//if the enemy is alive set it's picture to be alive
					}//if the monster is a Plague knight and he dies
				}else if (MonsterName.getText().equals("Plague Knight")) {
					if (Player2.AmDead()) {
						SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/PlagueKnightDead.png")));//set picture to dead Plague knight
						Player1.EndCombat();//end combat for the player (Cleanup)
						Player1.SetGold(Player1.GetGold() + Player2.GetReward());//give the player the gold reward
						IsEnemy = false;
					}else {
						SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/PlagueKnight.png"))); //if the enemy is alive set it's picture to be alive
						
					}
				}
			}
	}
	/**
	 * The Enemys turn after the player casts a regular action
	 */
	private void EnemyTurn() {
		if (!Player2.AmDead()) {//if hes not dead
			
			Player1.StartTurn(); //Start turn (Status effect countdowns) even though it's not the start of the first players turn, if the player1 activates cooldowns after player2 attacks then player1 buffs (Invulnerable) will last for a turn and a half preventing 2 attacks
			Player2.StartTurn(); //Startturn (Status effect countdowns)
				
				
					TempCount = rng.nextInt(3) + 1; //The greatest AI, a random number generator
					
					do { //prevents "ai" from spam casting the same spells stun locking you
 					 if (TempCount == TempCount2) {//checks to if the the spell being cast this time is the same as last time, if it is re roll
						TempCount = rng.nextInt(3) + 1;
					}
					}while(TempCount == TempCount2);
					
					TempCount2 = TempCount; 
					
					
				
				
				if(TempCount == 1) {
					IncommingSpell = Player2.SpellSlot1(); //call the spellslot method from the player 
					
				}else if(TempCount == 2) {
					IncommingSpell = Player2.SpellSlot2();//call the spellslot method from the player 
					
				}else if(TempCount == 3) {
					IncommingSpell = Player2.SpellSlot3();//call the spellslot method from the player 
					
				}
				
				//
				//Outputs what the enemy is doing the the combat log
				if (Player1.Invulnerable) {
					AddCombatLog("The Enemy attacked but you are Invulnerable");
					
				}
				else if (IncommingSpell[3].equals("Actions is Exausted on")) {
					AddCombatLog("Enemy's Quick Actions are Exausted");
					
				}else if (IncommingSpell[3].equals("Paralyzed")) {
					AddCombatLog("Enemy is Paralyzed");
					
				}else if (IncommingSpell[3].equals("on Cooldown")) {
					AddCombatLog("Enemy's spell is on Cooldown");
					
				}else if (IncommingSpell[3].equals("Damage/Heal")) {
					IncommingSpell[3] = "Damage";
					AddCombatLog("Enemy Hits you Dealing " + IncommingSpell[4] + " Damage and Heals for " + IncommingSpell[4] );
					
				}else if (IncommingSpell[3].equals("Damage")) {
					AddCombatLog("Enemy Hits you Dealing " + IncommingSpell[4] + " Damage");
					
				}else {
					AddCombatLog("Enemy casts " + IncommingSpell[0] + " on you, for " + IncommingSpell[1] + " Turns");
				}
				//hits player1 with the spell
				Player1.GotHitWith(IncommingSpell);
					UpdateBattlefield();//updates the GUI 
		}
	}
	
	/**
	 * This Method adds the string to the Combat log
	 */
	private void AddCombatLog(String BottemText) {
		 CombatLog.append("\n" + BottemText);
		 CombatLog.setCaretPosition(CombatLog.getDocument().getLength());
		 
	}
	
	/**
	 * Redraws and updates images and variables that are used on the battlefield panel
	 */
	private void UpdateBattlefield() {
		TempCount = 0;
		PlayerHealth.setValue(Player1.GetHealth()); //updates progress bar for player health
		if (IsEnemy) {
		MonsterHealth.setValue(Player2.GetHealth());} //updates progress bar for enemy health
		
		IsAnyoneDed(); //run this method to check if anyone died, to update the field with there death
		
		AmountGold.setText(Integer.toString(Player1.GetGold()));
		
		/**
		 * Visually shows the available actions you have
		 */
		if(Player1.GetActions()[0]) {
			Action0.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Blue.png")));
		} else {
			Action0.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Grey.png")));
		}
		if(Player1.GetActions()[1]) {
			Action1.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		} else {
			Action1.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Grey.png")));
		}
		if(Player1.GetActions()[2]) {
			Action2.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		} else {
			Action2.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Grey.png")));
		}
		if(Player1.GetActions()[3]) {
			Action3.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		} else {
			Action3.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Grey.png")));
		}
		
		/**
		 * Visually shows the StatusEffect you have on you
		 */
		if (Player1.GetStatus().get("Pestilence") != null) {
			if (Player1.GetStatus().get("Pestilence") > 0) {
				this.HavePestilence.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/PestilenceIcon.png")));
			}else {this.HavePestilence.setIcon(null);
				  }
		}
		if (Player1.GetStatus().get("CurseOfAThousandNeedles") != null) {
			if (Player1.GetStatus().get("CurseOfAThousandNeedles") > 0) {
				this.HaveNeedles.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/NeedleIcon.png")));
			}else {this.HaveNeedles.setIcon(null);
				  }
		}
		if (Player1.GetStatus().get("DoubleDamage") != null) {
			if (Player1.GetStatus().get("DoubleDamage") > 0) {
				this.HaveDouble.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/DoubleIcon.png")));
			}else {this.HaveDouble.setIcon(null);
				  }
		}
		if (Player1.GetStatus().get("Invulnerable") != null) {
			if (Player1.GetStatus().get("Invulnerable") > 0) {
				this.HaveInvulnerable.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/InvulnerableIcon.png")));
			}else {this.HaveInvulnerable.setIcon(null);
				  }
		}
			if (Player1.Paralyzed) {
				this.HaveParalyze.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/StunnedIcon.png")));
			}else {this.HaveParalyze.setIcon(null);
				  }
		
		
		TheGame.repaint();
		TheGame.revalidate();
	}
	
	/**
	 * Sets the icons for the spellSelection screen
	 */
	private ImageIcon SpellPickerPicture(String SpellName) {
		ImageIcon picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png"));
		if (SpellName.equals("Polymorph")) {
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/polymorph.png"));
		}else if (SpellName.equals("MageFist")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/MageFist.png"));
		}else if (SpellName.equals("ArcanePower")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/arcanepower.png"));
		}else if (SpellName.equals("Blink")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Blink.png"));
		}else if (SpellName.equals("ArcaneMissles")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/arcanemissles.png"));
		}else if (SpellName.equals("RadiantWard")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/RadiantWard.png"));
		}else if (SpellName.equals("BoomerangShield")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/BoomerangShield.png"));
		}else if (SpellName.equals("DivineFavor")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/DivineFavor.png"));
		}else if (SpellName.equals("Aegis")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/aegis.png"));
		}else if (SpellName.equals("HammerOfRighteousness")) { 
			picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/HammerOfRightOffThePage.png"));
		}
		return picture;
	}
	
	/**
	 * Runns when you choose the mage class to play as
	 */
	private void ClassMage() {
		Class = "Mage";
		Player1 = new HeroArcaneMage();
		ChangeWindow(SpellSelection);
		
		/**
		 * Changes the images of the spell slots to reflect what spell they will cast
		 */
		this.Spell1.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/polymorph.png")));
		this.SpellText1.setText("<html>Transform Target into a sheep making them <br> unable to use actions for 1 turn</html>");

		this.Spell2.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/MageFist.png")));
		this.SpellText2.setText("<html>Form energy into a solid mass to <br> deal 6 damage to target</html>");
		
		this.Spell3.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/arcanepower.png")));
		this.SpellText3.setText("<html>Imbue yourself with power Causing <br> your next attack to deal double damage </html>");
		
		this.Spell4.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Blink.png")));
		this.SpellText4.setText("<html>Whisk yourself through space in an instant <br> dodging the next 1 attack </html>");
		
		this.Spell5.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/arcanemissles.png")));
		this.SpellText5.setText("<html>Hurdle 3 octahedron at your target <br> Dealing 1d2, 1d4, and 1d6 damage </html>");
	}
	
	/**
	 * Runns when you choose the Paladin class to play as
	 */
	private void ClassPaladin() {
		Class = "Paladin";
		Player1 = new HeroPaladin();
		ChangeWindow(SpellSelection);
		
		/**
		 * Changes the images of the spell slots to reflect what spell they will cast
		 */
		this.Spell1.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/RadiantWard.png")));
		this.SpellText1.setText("<html>Summon a holy shield to surround yourself with <br> Healing 1d6+2 damage </html>");

		this.Spell2.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/BoomerangShield.png")));
		this.SpellText2.setText("<html>Throw your shield in a manner that causes it to loop back <br> Dealing 6 damage </html>");
		
		this.Spell3.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/DivineFavor.png")));
		this.SpellText3.setText("<html>Call upon the gods to aid you <br> Restore all your actions </html>");
		
		this.Spell4.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/aegis.png")));
		this.SpellText4.setText("<html>Protect yourself for a turn <br> reducing anydamge taken next turn to 0 </html>");
		
		this.Spell5.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/HammerOfRightOffThePage.png")));
		this.SpellText5.setText("<html>Smash your hammer into the target <br> Dealing Half your life lost this battle</html>");
	}
	
	
	/**
	 * Initialzing all the frames, panels, buttons and labels
	 */
	private void initialize() {		
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 807, 620);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("Invergotten Realms");
		this.frame.setResizable(false);
		this.frame.getContentPane().setLayout(null);
		
		this.TheGame = new JPanel();
		this.TheGame.setBounds(0, 0, 800, 600);
		this.frame.getContentPane().add(this.TheGame);
		this.TheGame.setLayout(new CardLayout(0, 0));
		
		//StartWindow setup
		this.StartWindow = new JPanel();
		this.TheGame.add(this.StartWindow);
		this.StartWindow.setLayout(null);
		
		
		/**
		 * Start menu button to start the game, 
		 */
		this.StartButton = new JLabel(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SinglePlayerUnselected.png")));
		this.StartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				ImageIcon picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SinglePlayerselected.png"));
				SetStartButtonIcon(picture);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ImageIcon picture = new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SinglePlayerUnselected.png"));
				SetStartButtonIcon(picture);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangeWindow(ClassSelection);
			}
		});
		this.StartButton.setBounds(241, 153, 291, 27);
		this.StartWindow.add(this.StartButton);
				
		this.StartBackground = new JLabel(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/StartMenu.png")));
		this.StartBackground.setBounds(0, 0, 800, 600);
		this.StartWindow.add(this.StartBackground);
		
		/**
		 * Class selection setup
		 */
		this.ClassSelection = new JPanel();
		this.TheGame.add(this.ClassSelection);
		
		this.ClassBackground = new JLabel();
		this.ClassBackground.setBounds(0, 0, 800, 600);
		this.ClassBackground.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/CharacterSelection1.png")));
		this.ClassSelection.setLayout(null);
		
		/**
		 * Choose Mage as character class
		 */
		this.Mage = new JLabel("");
		this.Mage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ClassMage();//calls classmage method
			}
		});
		this.Mage.setBounds(36, 22, 280, 530);
		this.ClassSelection.add(this.Mage);
		
		/**
		 * Choose Paladin as Character class
		 */
		this.Paladin = new JLabel("");
		this.Paladin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ClassPaladin();//calls ClassPaladin method
			}
		});
		this.Paladin.setBounds(420, 32, 280, 530);
		this.ClassSelection.add(this.Paladin);
		this.ClassSelection.add(this.ClassBackground);
		
		/**
		 * Spell Selection setup
		 */
		this.SpellSelection = new JPanel();
		this.TheGame.add(this.SpellSelection);
		this.SpellSelection.setLayout(null);
		
		/**
		 * setting Spell 1 on the spell selection screen 
		 */
		this.Spell1 = new JLabel();
		this.Spell1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.GetSpellBook().size() < 3) {
					if (Class.equals("Mage")) {
						if((!Player1.GetSpellBook().contains("Polymorph"))){ //if your a mage set the first pic to Polymorph if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("Polymorph");
							SetSpell1Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("Polymorph");
							SetSpell1Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Polymorph.png")));
						}
						
					}else if (Class.equals("Paladin")) {
						if((!Player1.GetSpellBook().contains("RadiantWard"))){ //if your a paladin set the first pic to RadiantWard if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("RadiantWard");
							SetSpell1Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("RadiantWard");
							SetSpell1Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/RadiantWard.png")));
						}
					}
				} 
				if (Player1.GetSpellBook().size() == 3) { //if your spell book has 3 spells go to the battlefield
					EnterTheBattlefield();
				}
			}
		});
		this.Spell1.setBounds(10, 103, 350, 100);
		this.SpellSelection.add(this.Spell1);
		
		this.SpellText1 = new JLabel();
		this.SpellText1.setBounds(120, 103, 250, 100);
		this.SpellSelection.add(this.SpellText1);
		
		/**
		 * setting Spell 2 on the spell selection screen 
		 */
		this.Spell2 = new JLabel();
		this.Spell2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.GetSpellBook().size() < 3) {
					if (Class.equals("Mage")) {
						if((!Player1.GetSpellBook().contains("MageFist"))){//if your a mage set the first pic to Magefist if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("MageFist");
							SetSpell2Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("MageFist");
							SetSpell2Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/MageFist.png")));
						}
						
					}else if (Class.equals("Paladin")) {
						if((!Player1.GetSpellBook().contains("BoomerangShield"))){ //if your a paladin set the first pic to BoomerangShield if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("BoomerangShield");
							SetSpell2Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("BoomerangShield");
							SetSpell2Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/BoomerangShield.png")));
						}
					}
				} 
				if (Player1.GetSpellBook().size() == 3) {//if your spell book has 3 spells go to the battlefield
					EnterTheBattlefield();
				}
			}
		});
		this.Spell2.setBounds(10, 266, 350, 100);
		this.SpellSelection.add(this.Spell2);
		
		this.SpellText2 = new JLabel();
		this.SpellText2.setBounds(120, 266, 250, 100);
		this.SpellSelection.add(this.SpellText2);
		
		/**
		 * setting Spell 3 on the spell selection screen 
		 */
		this.Spell3 = new JLabel();
		this.Spell3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.GetSpellBook().size() < 3) {
					if (Class.equals("Mage")) {
						if((!Player1.GetSpellBook().contains("ArcanePower"))){//if your a mage set the first pic to ArcanePower if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("ArcanePower");
							SetSpell3Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("ArcanePower");
							SetSpell3Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/arcanePower.png")));
						}
						
					}else if (Class.equals("Paladin")) {
						if((!Player1.GetSpellBook().contains("DivineFavor"))){//if your a paladin set the first pic to DivineFavor if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("DivineFavor");
							SetSpell3Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("DivineFavor");
							SetSpell3Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/DivineFavor.png")));
						}
					}
				} 
				if (Player1.GetSpellBook().size() == 3) {//if your spell book has 3 spells go to the battlefield
					EnterTheBattlefield();
				}
			}
		});
		this.Spell3.setBounds(10, 426, 350, 100);
		this.SpellSelection.add(this.Spell3);
		
		this.SpellText3 = new JLabel();
		this.SpellText3.setBounds(120, 426, 250, 100);
		this.SpellSelection.add(this.SpellText3);
		
		/**
		 * setting Spell 4 on the spell selection screen 
		 */
		this.Spell4 = new JLabel();
		this.Spell4.setHorizontalAlignment(SwingConstants.TRAILING);
		this.Spell4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.GetSpellBook().size() < 3) {
					if (Class.equals("Mage")) {
						if((!Player1.GetSpellBook().contains("Blink"))){//if your a mage set the first pic to Blink if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("Blink");
							SetSpell4Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("Blink");
							SetSpell4Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Blink.png")));
						}
						
					}else if (Class.equals("Paladin")) {
						if((!Player1.GetSpellBook().contains("Aegis"))){//if your a paladin set the first pic to Aegis if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("Aegis");
							SetSpell4Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("Aegis");
							SetSpell4Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/aegis.png")));
						}
					}
				} 
				if (Player1.GetSpellBook().size() == 3) {//if your spell book has 3 spells go to the battlefield
					EnterTheBattlefield();
				}
			}
		});
		this.Spell4.setBounds(411, 103, 350, 100);
		this.SpellSelection.add(this.Spell4);
		
		this.SpellText4 = new JLabel();
		this.SpellText4.setBounds(411, 103, 250, 100);
		this.SpellSelection.add(this.SpellText4);
		
		/**
		 * setting Spell 5 on the spell selection screen 
		 */
		this.Spell5 = new JLabel();
		this.Spell5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.GetSpellBook().size() < 3) {
					if (Class.equals("Mage")) {
						if((!Player1.GetSpellBook().contains("ArcaneMissles"))){//if your a mage set the first pic to Blink if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("ArcaneMissles");
							SetSpell5Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("ArcaneMissles");
							SetSpell5Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/ArcaneMissles.png")));
						}
						
					}else if (Class.equals("Paladin")) {
						if((!Player1.GetSpellBook().contains("HammerOfRighteousness"))){//if your a paladin set the first pic to HammerOfRighteousness if it's clicked add it to player1's spellbook
							Player1.AddSpellBook("HammerOfRighteousness");
							SetSpell5Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Learned.png")));
						}else {
							Player1.RemoveSpellBook("HammerOfRighteousness");
							SetSpell5Icon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/HammerOfRightOffThePage.png")));
						}
					}
				} 
				if (Player1.GetSpellBook().size() == 3) {//if your spell book has 3 spells go to the battlefield
					EnterTheBattlefield();
				}
			}
		});
		this.Spell5.setHorizontalAlignment(SwingConstants.TRAILING);
		this.Spell5.setBounds(411, 266, 350, 100);
		this.SpellSelection.add(this.Spell5);
		
		this.SpellText5 = new JLabel();
		this.SpellText5.setBounds(411, 266, 250, 100);
		this.SpellSelection.add(this.SpellText5);
		
		this.SpellBackground = new JLabel();
		this.SpellBackground.setBounds(0, 0, 800, 600);
		this.SpellSelection.add(this.SpellBackground);
		this.SpellBackground.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/backgggg.png")));
		/**
		 * setting Weapon Screen
		 */
		
		this.WeaponSelection = new JPanel();
		this.TheGame.add(this.WeaponSelection);
		this.WeaponSelection.setLayout(null);
		/**
		 * When this button is clicked go to the battlefield from the weapon screen
		 */
		this.WeaponBack = new JButton("Back");
		this.WeaponBack.setBounds(725, 566, 65, 23);
		this.WeaponBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangeWindow(Battlefield);
				UpdateBattlefield();
			}
		});
		this.WeaponSelection.add(this.WeaponBack);
		
		//Prices and description of the Sword
		this.FeastText = new JLabel("<html>Sword of Feast and Famine (80g)<br> You gain an extra action and your target loses a quick actions <br> You can only basic attack once with this sword</html>");
		this.FeastText.setBounds(58, 11, 250, 100);
		this.WeaponSelection.add(this.FeastText);
		
		//Prices and description of the Sword
		this.FightingText = new JLabel("<html>Sword of Fighting And Friendship (150g)<br> Double your damage and become invulnerable until next round <br> You can only basic attack once with this sword</html>");
		this.FightingText.setBounds(286, 489, 250, 100);
		this.WeaponSelection.add(this.FightingText);
		
		/**
		 * When the Feast and Famine Sword is clicked
		 */
		this.FeastAndFamine = new JLabel("");
		this.FeastAndFamine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFeastAndFamine")) { //on hover show some effects
				FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFamineActivated.png")));}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFeastAndFamine")) {//on leave show remove those effects
				FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFamine.png")));}
			}
			@Override
			public void mouseReleased(MouseEvent e) { //If you can aford the sword you buy it changing it's look
				if (Player1.Gold >= 80) {
					Player1.SetGold(Player1.GetGold() - 80);
					NewWeapon = new SwordOfFeastAndFamine("SwordOfFeastAndFamine", "0", "0", "PowerWeapon", "3", "", "");
					Player1.SetCurrentWeapon(NewWeapon);
				FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFaminePowered.png")));
				FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendship.png"))); //unequipped the other swords
				FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFire.png")));
				}
			}
		});
		
		this.FireText = new JLabel("<html>Sword of Frost And Fire (200g)<br> Freeze your target and hit them with a Fireball <br> You can only basic attack once with this sword</html>");
		this.FireText.setBounds(550, 11, 250, 100);
		this.WeaponSelection.add(this.FireText);
		this.FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFamine.png")));
		this.FeastAndFamine.setBounds(58, 89, 175, 500);
		this.WeaponSelection.add(this.FeastAndFamine);
		
		/**
		 * When the Frost and Fire Sword is clicked
		 */
		this.FrostAndFire = new JLabel("");
		this.FrostAndFire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFrostAndFire")) {//on hover show some effects
				FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFireActivated.png")));}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFrostAndFire")) {//on leave show remove those effects
				FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFire.png")));}
			}
			@Override
			public void mouseReleased(MouseEvent e) {//If you can aford the sword you buy it changing it's look
				if (Player1.Gold >= 200) {
					Player1.SetGold(Player1.GetGold() - 200);
					NewWeapon = new SwordOfFrostAndFire("SwordOfFrostandFire", "0", "0", "PowerWeapon", "3", "", "");
					Player1.SetCurrentWeapon(NewWeapon);
					FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFirePowered.png")));
					FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFamine.png")));//unequipped the other swords
					FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendship.png")));
				}
			}
		});
		this.FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFire.png")));
		this.FrostAndFire.setBounds(573, 100, 175, 500);
		this.WeaponSelection.add(this.FrostAndFire);
		
		/**
		 * When the Fight and Friendship Sword is clicked
		 */
		this.FightingAndFriendShip = new JLabel("");
		this.FightingAndFriendShip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFightAndFriendship")) {//on hover show some effects
				FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendshipActivated.png")));}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (!Player1.GetCurrentWeapon().WeaponName().equals("SwordOfFightAndFriendship")) {//on leave show remove those effects
				FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendship.png")));}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (Player1.Gold >= 150) {
					Player1.SetGold(Player1.GetGold() - 150);
					NewWeapon = new SwordOfFightingAndFriendship("SwordOfFightAndFriendship", "0", "0", "PowerWeapon", "3", "", "");
					Player1.SetCurrentWeapon(NewWeapon);
					FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendshipPowered.png")));
					FrostAndFire.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFrostAndFire.png")));//unequipped the other swords
					FeastAndFamine.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFeastAndFamine.png")));
				}
			}
		});
		this.FightingAndFriendShip.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/SwordOfFightAndFriendship.png")));
		this.FightingAndFriendShip.setBounds(318, 11, 175, 500);
		this.WeaponSelection.add(this.FightingAndFriendShip);
		
		this.WeaponBackground = new JLabel((String) null);
		this.WeaponBackground.setBounds(0, 0, 800, 600);
		this.WeaponBackground.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Weaponrack.png")));
		this.WeaponSelection.add(this.WeaponBackground);
		
		this.Battlefield = new JPanel();
		this.TheGame.add(this.Battlefield);
		this.Battlefield.setLayout(null);
		
		/**
		 * Basic Attack "Spell" which uses the weapons abilitys to hit enemy
		 */
		this.BasicAttack = new JLabel("New label");
		this.BasicAttack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (IsEnemy) {
					IncommingSpell = Player1.WeaponAttack();
					if (IncommingSpell[3].equals("PowerWeapon")) { //if your weapon has the attribute PowerWeapon,run the attack 3 times for each of it's effects
						AddCombatLog("You use your magic sword and swing at the enemy");
						Attack(Player1.GetCurrentWeapon().WeaponEffects[0]);
						Attack(Player1.GetCurrentWeapon().WeaponEffects[1]);
						Attack(Player1.GetCurrentWeapon().WeaponEffects[2]);
					}else {                 //if your weapon is not a power weapon attack as normal
					Attack(IncommingSpell);
					}
					UpdateBattlefield(); //update the battlefield
					if (IncommingSpell[6].equals("1") || IncommingSpell[6].equals("2") || IncommingSpell[6].equals("3")) { //if the spell (IncommingSpell) uses a Quick Action then it does not end your turn
						SuccessfullHit = false;
					}
					if (SuccessfullHit) {// if you hit with a spell that uses a regular action it becomes the enemys turn
						EnemyTurn();
					}
				} else {AddCombatLog("There is no enemy to attack");} //if there is no enemy  you can't cast spells
			}
		});
		this.BasicAttack.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/BasicAttack.png")));
		this.BasicAttack.setBounds(31, 489, 100, 100);
		this.Battlefield.add(this.BasicAttack);
		
		/**
		 * SpellSlotFirst "Spell" which uses the players SpellSlot1() to affect the enemy
		 */
		this.SpellSlotFirst = new JLabel("Empty");
		this.SpellSlotFirst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (IsEnemy) {
					IncommingSpell = Player1.SpellSlot1();
					Attack(IncommingSpell);//call attack method
					UpdateBattlefield();//update battlefield
					
					if (IncommingSpell[6].equals("1") || IncommingSpell[6].equals("2") || IncommingSpell[6].equals("3")) {//if the spell (IncommingSpell) uses a Quick Action then it does not end your turn
						SuccessfullHit = false;
					}
					if (SuccessfullHit) {// if you hit with a spell that uses a regular action it becomes the enemys turn
						EnemyTurn();
					}
				} else {AddCombatLog("There is no enemy to attack");}//if there is no enemy  you can't cast spells
			}
		});
		this.SpellSlotFirst.setBounds(165, 489, 100, 100);
		this.Battlefield.add(this.SpellSlotFirst);
		
		/**
		 * SpellSlotTHIRD(i know it's not in order) "Spell" which uses the players SpellSlot3() to affect the enemy
		 */
		this.SpellSlotThird = new JLabel("Empty");
		this.SpellSlotThird.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (IsEnemy) {
					IncommingSpell = Player1.SpellSlot3();
					Attack(IncommingSpell);//call attack method
					UpdateBattlefield();//update battlefield
					if (IncommingSpell[6].equals("1") || IncommingSpell[6].equals("2") || IncommingSpell[6].equals("3")) {//if the spell (IncommingSpell) uses a Quick Action then it does not end your turn
						SuccessfullHit = false;
					}
					if (SuccessfullHit) {// if you hit with a spell that uses a regular action it becomes the enemys turn
						EnemyTurn();
					}
				} else {AddCombatLog("There is no enemy to attack");}//if there is no enemy  you can't cast spells
			}
		});
		this.SpellSlotThird.setBounds(426, 489, 100, 100);
		this.Battlefield.add(this.SpellSlotThird);
		
		/**
		 * SpellSlotSecond(i know it's not in order) "Spell" which uses the players SpellSlot2() to affect the enemy
		 */
		this.SpellSlotSecond = new JLabel("Empty");
		this.SpellSlotSecond.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (IsEnemy) {
					IncommingSpell = Player1.SpellSlot2();
					Attack(IncommingSpell);//call attack method
					UpdateBattlefield();//update battlefield
					if (IncommingSpell[6].equals("1") || IncommingSpell[6].equals("2") || IncommingSpell[6].equals("3")) {//if the spell (IncommingSpell) uses a Quick Action then it does not end your turn
						SuccessfullHit = false;
					}
					if (SuccessfullHit) {// if you hit with a spell that uses a regular action it becomes the enemys turn
						EnemyTurn();
					}
				} else {AddCombatLog("There is no enemy to attack");}//if there is no enemy  you can't cast spells
			}
		});
		this.SpellSlotSecond.setBounds(296, 489, 100, 100);
		this.Battlefield.add(this.SpellSlotSecond);
		/**
		 * Names and labels init for battlefield
		 */
		
		this.AmountGold = new JLabel("0");
		this.AmountGold.setBounds(461, 444, 46, 14);
		this.Battlefield.add(this.AmountGold);
		
		this.MonsterName = new JLabel("Empty");
		this.MonsterName.setBounds(296, 11, 100, 14);
		this.Battlefield.add(this.MonsterName);
		
		this.PlayerName = new JLabel(Class);
		this.PlayerName.setBounds(103, 444, 75, 14);
		this.Battlefield.add(this.PlayerName);
		
		this.TheWordGold = new JLabel("Gold");
		this.TheWordGold.setBounds(461, 430, 46, 14);
		this.Battlefield.add(this.TheWordGold);
		
		this.MonsterPic = new JLabel("");
		this.MonsterPic.setBounds(10, -67, 340, 525);
		this.Battlefield.add(this.MonsterPic);
		
		this.Action1 = new JLabel("");
		this.Action1.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		this.Action1.setBounds(247, 420, 64, 64);
		this.Battlefield.add(this.Action1);
		
		this.Action2 = new JLabel("");
		this.Action2.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		this.Action2.setBounds(313, 420, 64, 64);
		this.Battlefield.add(this.Action2);
		
		this.Action3 = new JLabel("");
		this.Action3.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Red.png")));
		this.Action3.setBounds(379, 420, 64, 64);
		this.Battlefield.add(this.Action3);
		
		this.Action0 = new JLabel("");
		this.Action0.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Blue.png")));
		this.Action0.setBounds(181, 420, 64, 64);
		this.Battlefield.add(this.Action0);
		
		this.MonsterHealth = new JProgressBar();
		this.MonsterHealth.setStringPainted(true);
		this.MonsterHealth.setMaximum(20);
		this.MonsterHealth.setForeground(Color.RED);
		this.MonsterHealth.setBounds(278, 30, 146, 14);
		this.Battlefield.add(this.MonsterHealth);
		
		this.PlayerHealth = new JProgressBar();
		this.PlayerHealth.setStringPainted(true);
		this.PlayerHealth.setBackground(Color.WHITE);
		this.PlayerHealth.setMaximum(20);
		this.PlayerHealth.setForeground(Color.RED);
		this.PlayerHealth.setBounds(31, 463, 146, 14);
		this.Battlefield.add(this.PlayerHealth);
		
		/**
		 * Initalizing Visual StatusEffects
		 */
		
		this.HavePestilence = new JLabel("");
		this.HavePestilence.setIcon(null);
		this.HavePestilence.setBounds(10, 430, 32, 32);
		this.Battlefield.add(this.HavePestilence);
		
		this.HaveNeedles = new JLabel("");
		this.HaveNeedles.setIcon(null);
		this.HaveNeedles.setBounds(41, 430, 32, 32);
		this.Battlefield.add(this.HaveNeedles);
		
		this.HaveDouble = new JLabel("");
		this.HaveDouble.setIcon(null);
		this.HaveDouble.setBounds(74, 426, 32, 32);
		this.Battlefield.add(this.HaveDouble);
		
		this.HaveInvulnerable = new JLabel("");
		this.HaveInvulnerable.setIcon(null);
		this.HaveInvulnerable.setBounds(136, 426, 32, 32);
		this.Battlefield.add(this.HaveInvulnerable);
		
		this.HaveParalyze = new JLabel("");
		this.HaveParalyze.setIcon(null);
		this.HaveParalyze.setBounds(103, 426, 32, 32);
		this.Battlefield.add(this.HaveParalyze);
		
		/**
		 * Summoning Monster button
		 */
		this.SummonMonster = new JButton("Find Monster");
		this.SummonMonster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CombatLog.setText("Combat Log:"); //reset the combat log
				if (IsEnemy == false) { //if there is no enemy(so you can make one)
					TempCount = rng.nextInt(2); //randomly choose 1 of 2 enemies
					
					if (TempCount == 0) {
						Player2 = new EnemyWarlock(); //set Player2 (the enemy) to a Warlock
					    SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/Warlock.png")));
					    IsEnemy = true;
					    MonsterHealth.setMaximum(Player2.GetHealth()); //set the healthbar on the battlefield
					    MonsterName.setText("Warlock");
					    Player1.EndCombat(); //end combat for the player (Cleanup)
					    Player1.StartTurn(); //Start turn for status effect and such
					    AddCombatLog("You Have Summoned a Warlock");
					   
					}else {
						Player2 = new EnemyPlagueKnight();//set Player2 (the enemy) to a PlagueKnight
					    SetMonsterPicIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/PlagueKnight.png")));
					    IsEnemy = true;
					    MonsterHealth.setMaximum(Player2.GetHealth());//set the healthbar on the battlefield
					    MonsterName.setText("Plague Knight");
					    Player1.EndCombat(); //end combat for the player (Cleanup)
					    Player1.StartTurn(); //Start turn for status effect and such
					    AddCombatLog("You Have Summoned a Plague Knight");
					}
				} else {AddCombatLog("There is alread a Monster, no running away");}
				UpdateBattlefield();
			}
		});
		
		/**
		 * Create the Combat log
		 */
		this.CombatLog = new JTextArea();
		this.CombatLog.setEditable(false);
		this.CombatLog.setFont(new Font("Monospaced", Font.PLAIN, 11));
		this.CombatLog.setText("Combat Log:");
		
		Scroll = new JScrollPane(CombatLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //add a scroll bar for when there is to much combat
		this.Scroll.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 255), new Color(0, 255, 255)));
		this.Scroll.setBounds(493, 56, 297, 417);
		this.Battlefield.add(Scroll);

		
		
		this.SummonMonster.setBounds(486, 7, 107, 23);
		this.Battlefield.add(this.SummonMonster);
		
		/**
		 * ToShop Button, loads the shop
		 */
		this.ToShop = new JButton("Shop");
		this.ToShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (IsEnemy == false) {
					Player2 = null;
				ChangeWindow(WeaponSelection);
				
				}
			}
		});
		this.ToShop.setBounds(556, 489, 89, 23);
		this.Battlefield.add(this.ToShop);
		
		/**
		 * Endgame and YouDied panels initialize
		 */
		this.EndGame = new JPanel();
		this.TheGame.add(this.EndGame);
		this.EndGame.setLayout(null);
		
		this.YouDied = new JLabel("");
		this.YouDied.setBounds(0, 0, 800, 600);
		this.YouDied.setIcon(new ImageIcon(PlayervsPlayerWindow.class.getResource("/Resources/YouDied.png")));
		this.EndGame.add(this.YouDied);
	}
}
