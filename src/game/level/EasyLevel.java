package game.level;

import java.util.Random;

import game.objects.GameObject;

public class EasyLevel implements ILevel {
	private Random Random ;
	
	public EasyLevel() {
		Random = new Random();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getNumberOfObjects() {
		int noshapes = Random.nextInt(2)+1;
		return noshapes;
	}

	@Override
	public void setObjectsVelocity(GameObject gameObject) {
		
		//gameObject.setFallingVelocity();  Easy level no speed change
		//gameObject.setInitialVelocity();
		
		
		
	}

}
