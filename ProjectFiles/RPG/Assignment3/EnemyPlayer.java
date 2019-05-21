package Assignment3;

/**
 * Parent class for all enemies
 */
public abstract class EnemyPlayer extends BasePlayer {
	
	protected int Reward; //enemys will reward players with gold
	
public EnemyPlayer() {	
	
	}


public int GetReward() { //getter
	return Reward;
}


}