package game.level;

import java.util.Random;

import game.objects.GameObject;

public class HardLevel implements ILevel {
	
private Random Random ;
	
	public HardLevel() {
		Random = new Random();
	}

	@Override
	public int getNumberOfObjects() {
		int noshapes = Random.nextInt(6)+1;
		return noshapes;
	}

	@Override
	public void setObjectsVelocity(GameObject gameObject) {
		
		gameObject.setFallingVelocity();  
		gameObject.setInitialVelocity();
		gameObject.setFallingVelocity();  
		gameObject.setInitialVelocity();
		
		
		
	}


}
