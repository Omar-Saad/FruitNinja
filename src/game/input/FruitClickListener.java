package game.input;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import game.objects.GameObject;

public class FruitClickListener implements MouseMotionListener {
	
	private int x,y;
	private Rectangle rectangle;
	private ArrayList<Rectangle> r ;
	private boolean isClicked;
	private ArrayList<GameObject> g;

	
	
		public FruitClickListener() {
			
			isClicked = false;
			rectangle = new Rectangle(64, 64);
			r = new ArrayList<Rectangle>();
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

	@SuppressWarnings("deprecation")
	@Override
	public void mouseDragged(MouseEvent e) {
		
		isClicked = false;
		Point clicked = e.getPoint();
		r.clear();
		for(int i =0 ;i<g.size() ;i++) {
		rectangle.move(g.get(i).getXlocation(), g.get(i).getYlocation());
		r.add(rectangle);
		for(int j =0 ;j<r.size();j++) {
		
			
		if(r.get(i).contains(clicked))
		{
			//System.out.println("moved!");
			g.get(i).slice();
			
			isClicked = true;

		}
		}
			
		
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseMoved(MouseEvent e) {
		
		/*
		
	//Thread thread = new Thread(new Runnable() {
		
		//@Override
		//public void run() {
			isClicked = false;
			
			
			try {

			Point clicked = e.getPoint();
			//rectangle = new Rectangle(x, y, 64, 64);
			r.clear();
			if(!g.isEmpty()) {
			for(int i =0 ;i<g.size() ;i++) {
			rectangle.move(g.get(i).getXlocation(), g.get(i).getYlocation());
			r.add(rectangle);
			for(int j =0 ;j<r.size();j++) {
				//System.out.println(g.get(i).isSliced());
				
			if(r.get(i).contains(clicked))
			{
				//System.out.println("moved!");
				g.get(i).slice();
				isClicked = true;

			}
			}
				
			
			}		}	}
			catch (Exception e1) {
			}
		//}
	//});
	
	//thread.start();
		
		
		
		*/
		
		
		
		
		
	}

	public boolean isClicked() {
		return isClicked;
	}
	
	
	public ArrayList<GameObject> getG() {
		return g;
	}


	public void setG(ArrayList<GameObject> g) {
		this.g = g;
	}


	
	
	

}
