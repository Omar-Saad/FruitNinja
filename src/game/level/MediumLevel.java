package game.level;

import java.util.Random;

import game.objects.GameObject;

public class MediumLevel implements ILevel {
private Random Random ;
	
	public MediumLevel() {
		Random = new Random();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getNumberOfObjects() {
		int noshapes = Random.nextInt(4)+1;
		return noshapes;
	}

	@Override
	public void setObjectsVelocity(GameObject gameObject) {
		
		gameObject.setFallingVelocity();  
		gameObject.setInitialVelocity();
		
		
		
	}


}
