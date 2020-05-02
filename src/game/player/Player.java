package game.player;

import java.util.ArrayList;

import game.data.XmlFile;
import game.input.FruitClickListener;
import game.objects.GameObject;

public class Player   {
	
	private   int score , health;
	private int highScore;
	private int x , y;
	private static Player player ;
	private FruitClickListener clickListener;
	private XmlFile file;

	
	private Player() {
		
		clickListener = new FruitClickListener();
		score = 0;
		health = 3;
		file = new XmlFile();
		

	}
	
	
	public static Player getInstance() {
		
		if(player == null)
		
			player = new Player();
		
		return player;
		
	}
	
	public void slice(ArrayList<GameObject> fruit) {
		
		
		clickListener.setG(fruit);
		/*if(!fruit.isEmpty()) {
		for(int i=0 ;i<fruit.size() ;i++)
		{
			
			
			
			if(fruit.get(i) instanceof DangerousBomb ) {
				if(fruit.get(i).isSliced())
				player.updateHealth();
				System.out.println("h = "+health);
	
			}
			if(fruit.get(i) instanceof FatalBomb ) {
				if(fruit.get(i).isSliced()) {
				player.updateHealth();
				player.updateHealth();
				player.updateHealth();
				
				}
				//System.out.println("h = "+health);
	
			}
		}
		}*/
		

	}
	
	
	public void updateScore(int value) {
		
		score+=value;
		
	}

public void updateHealth() {
		
		health--;
		
	}





	
	
	
	
	
	//getters & setters
	
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public FruitClickListener getClickListener() {
		return clickListener;
	}


	public int getHighScore() {
		highScore = file.getHighscore();
		return highScore;
	}


	public void updateHighScore() {

		file.setHighscore(score);
	}



	


	
	
	
	
	
	

	

	
}
