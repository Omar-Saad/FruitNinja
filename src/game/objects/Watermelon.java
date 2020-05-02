package game.objects;

import java.awt.image.BufferedImage;
import java.util.Random;

import game.gfx.ImageLoader;

public class Watermelon implements GameObject {
	protected int x , y;
	protected boolean up;
	protected  boolean sliced ;
	private Random random;
	private int vel1 , vel2;
	public  Watermelon() {
	 
		y=500;
		up = true;
		random = new Random();
		x = random.nextInt(400);
		sliced = false;
		vel1 = 8;
		vel2 = 5;

	}
	

	@Override
	public int getXlocation() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getYlocation() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public int getInitialVelocity() {
		// TODO Auto-generated method stub
		return vel1;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return vel2;
	}

	@Override
	public Boolean isSliced() {
		// TODO Auto-generated method stub
		return sliced;
	}

	@Override
	public Boolean hasMovedOffScreen() {
		if(y > 500 || y < 0 || x > 700 || x < 0)
			return true;
		else
		
			
		return false;
	}

	@Override
	public void slice() {
		sliced = true;
		
	}

	@Override
	public void move() {
		if(!hasMovedOffScreen()) {

			
		if(y>getMaxHeight() && up && !isSliced()) {
		y = y - getInitialVelocity();}
		else 
			up = false;
		if(!up)
		{
			y = y+ getFallingVelocity();
		}
	//	x+=80;
		}
	}

	@Override
	public BufferedImage [] getBufferedImages() {
		BufferedImage img[] = new BufferedImage [2];
			img[0]=	ImageLoader.LoadImage("/textures/watermelon.png"); 
		img[1]= ImageLoader.LoadImage("/textures/watermeloncut.png"); 


		return img;
	}


	@Override
	public void setInitialVelocity() {

		vel1+=2;
	}


	@Override
	public void setFallingVelocity() {

		vel2+=3;

	}


	


}
