package game.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.gfx.ImageLoader;
import game.level.ILevel;
import game.player.Player;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener  {
	
	ArrayList<GameObject> gameObjects;
	private GameObjectFactory factory;
	public static BufferedImage Img[];
	private Random random;
	public   javax.swing.Timer t;
	private int noSHapes;
	private Player player;
	private JLabel scoreLabel;
	private JLabel live2;
	private JLabel live1;
	private JLabel live3;
	private JLabel labelPause;
	private JPanel PausePanel;
	private JLabel lblResume;
	//private GameOverPanel gover;
	private ILevel level;
	private JLabel lblHighscore;
	private JLabel lblTime;
	private JPanel gover;
	private int c;
	private long secondspassed  ;
	private long displayedMinutes ;
	private boolean running;

	public GamePanel (ILevel level) {
		
		random = new Random();
		gameObjects = new ArrayList <GameObject>();
		t = new javax.swing.Timer(50, this);
		factory =new GameObjectFactory();		
		noSHapes = 0;
		player =  Player.getInstance();
		this.level = level;
		 secondspassed = 0 ;
		  displayedMinutes =0 ;
		  running = true;
		setLayout(null);
		

		 
		 gover = new JPanel();
		 
		 gover.setLayout(null);
		 gover.setBounds(91, 52, 500, 467);
		 gover.setVisible(false);
		 add(gover);
		 JLabel label = new JLabel("");
		 label.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/gameover.png")));
		 label.setHorizontalAlignment(SwingConstants.CENTER);
		 label.setBounds(0, 0, 500, 467);
		 gover.add(label);
		 
		 JLabel lblYes = new JLabel("");
		 lblYes.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		running = true;
		 		t.restart();
		 		gover.setVisible(false);
		 	}
		 });
		 lblYes.setIcon(null);
		 lblYes.setHorizontalAlignment(SwingConstants.CENTER);
		 lblYes.setBounds(179, 338, 60, 41);
		 gover.add(lblYes);
		 
		 JLabel lblNo = new JLabel("");
		 lblNo.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		System.exit(1);


		 	}
		 });
		 lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNo.setBounds(261, 338, 60, 41);
		 gover.add(lblNo);
		
		 scoreLabel = new JLabel("");
		 scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 scoreLabel.setForeground(Color.WHITE);
		 scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		scoreLabel.setBounds(591, 11, 87, 29);
		scoreLabel.setText("Score : "+player.getScore());

		add(scoreLabel);
		
		live1 = new JLabel("");
		live1.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/live.png")));
		live1.setHorizontalAlignment(SwingConstants.CENTER);
		live1.setBounds(304, 11, 59, 43);
		add(live1);
		
		live2 = new JLabel("");
		live2.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/live.png")));
		live2.setHorizontalAlignment(SwingConstants.CENTER);
		live2.setBounds(373, 11, 59, 43);
		add(live2);
		
		live3 = new JLabel("");
		live3.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/live.png")));
		live3.setHorizontalAlignment(SwingConstants.CENTER);
		live3.setBounds(442, 11, 59, 43);
		add(live3);
		
		labelPause = new JLabel("");
		labelPause.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/pause.png")));
		
		labelPause.setForeground(Color.WHITE);
		labelPause.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPause.setHorizontalAlignment(SwingConstants.CENTER);
		labelPause.setBounds(10, 11, 46, 43);
		add(labelPause);
		
		lblHighscore = new JLabel("Highscore : ");
		lblHighscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighscore.setForeground(Color.WHITE);
		lblHighscore.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHighscore.setBounds(494, 12, 97, 29);
		add(lblHighscore);
		
		lblTime = new JLabel("0:0");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(591, 51, 87, 29);
		add(lblTime);
		
		
		PausePanel = new JPanel();
		PausePanel.setForeground(Color.WHITE);
		PausePanel.setBounds(51, 56, 605, 409);
		add(PausePanel);
		PausePanel.setLayout(null);
		
		JLabel lblcs = new JLabel("Current score");
		lblcs.setForeground(new Color(255, 165, 0));
		lblcs.setHorizontalAlignment(SwingConstants.CENTER);
		lblcs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblcs.setBounds(25, 112, 133, 27);
		PausePanel.add(lblcs);
		
		JLabel lbl_current_score = new JLabel("");
		lbl_current_score.setForeground(Color.WHITE);
		lbl_current_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_current_score.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_current_score.setBounds(195, 117, 51, 22);
		PausePanel.add(lbl_current_score);
		
		JLabel lblHighScore = new JLabel("High score");
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setForeground(new Color(255, 165, 0));
		lblHighScore.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHighScore.setBounds(25, 179, 133, 27);
		PausePanel.add(lblHighScore);
		
		JLabel lbl_highscroe_score = new JLabel("");
		lbl_highscroe_score.setForeground(Color.WHITE);
		lbl_highscroe_score.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_highscroe_score.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_highscroe_score.setBounds(195, 184, 51, 22);
		PausePanel.add(lbl_highscroe_score);
		
		lblResume = new JLabel("Resume");
		lblResume.setForeground(Color.WHITE);
		lblResume.setHorizontalAlignment(SwingConstants.CENTER);
		lblResume.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResume.setBounds(326, 260, 133, 41);
		PausePanel.add(lblResume);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GamePanel.class.getResource("/textures/pausebackground.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 605, 409);
		PausePanel.add(label_1);
		PausePanel.setVisible(false);
		
		labelPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				t.stop();
				running = false;
				PausePanel.setVisible(true);
				lbl_current_score.setText(""+player.getScore());
				lbl_highscroe_score.setText(""+player.getHighScore());
				lblResume.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						running = true;
						
					t.restart();
					PausePanel.setVisible(false);
					
					
					}
					
				});
			}
		});
				
		
		
		
		
			
		
		

		
		
	
		
		
		
		
		addMouseMotionListener(player.getClickListener());
		
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println("paint");
		g.drawImage(ImageLoader.LoadImage("/textures/background.png"), 0, 0, 700, 500, null);
		for(int i=0 ; i<gameObjects.size() ;i++)	{
			if(!gameObjects.get(i).isSliced())
		g.drawImage(gameObjects.get(i).getBufferedImages()[0],gameObjects.get(i).getXlocation(),gameObjects.get(i).getYlocation() ,64,64,null);
		
			else if(gameObjects.get(i).isSliced()) {

				g.drawImage(gameObjects.get(i).getBufferedImages()[1],gameObjects.get(i).getXlocation(),gameObjects.get(i).getYlocation() ,64,64,null);
						
				
			
			}}
		if(running)
		t.start();
		

	}
		
	public void generatreRamdomObject() {
		 noSHapes = level.getNumberOfObjects();
	
		
		for(int i=0 ;i<noSHapes ;i++)
		{
			
			GameObject go = factory.CreateGameObject(random.nextInt(7));
			level.setObjectsVelocity(go);
			gameObjects.add(go);

					
			
		}			

		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Toolkit.getDefaultToolkit().sync();

		tick();
		repaint();




		
	}
	
	
	
	public void tick() {
		
		for(int i =0 ;i<gameObjects.size();i++)
		{
	

				if((!gameObjects.get(i).hasMovedOffScreen()) && !gameObjects.get(i).isSliced() )
			{
									gameObjects.get(i).move();
				
			                    	player.slice(gameObjects);
		
			}
				else {//(gameObjects.get(i).hasMovedOffScreen()) {
				
					if(gameObjects.get(i) instanceof DangerousBomb || gameObjects.get(i) instanceof FatalBomb) {
						
					if(gameObjects.get(i) instanceof DangerousBomb  && gameObjects.get(i).isSliced() ) {
					
						player.updateHealth();				
						gameObjects.remove(i);
						
}
					else if(gameObjects.get(i) instanceof FatalBomb && gameObjects.get(i).isSliced() ) {
							player.updateHealth();	
							player.updateHealth();
							player.updateHealth();
							gameObjects.remove(i);
							endGame();
							
	
					}
					
					else if(gameObjects.get(i).hasMovedOffScreen() && !gameObjects.get(i).isSliced())
						gameObjects.remove(i);
						
					
					
					
					}
					else {
					
					
				 if(!gameObjects.get(i).hasMovedOffScreen() && gameObjects.get(i).isSliced())
				{
					 if(gameObjects.get(i) instanceof SpecialBanana5) {
						 player.updateScore(5);

					 }
					 else if(gameObjects.get(i) instanceof SpecialBanana10) {
						 player.updateScore(10);
						 
					 }
					 else
				
					player.updateScore(1);
					 }
					 
						 
				
				
				 if(gameObjects.get(i).hasMovedOffScreen() && !gameObjects.get(i).isSliced()) 
					player.updateHealth();
				
				
					gameObjects.remove(i);

				
								}}
		
		
		
		}
		if(gameObjects.isEmpty() || gameObjects.size() == 1)
			generatreRamdomObject();
		
		checkHealth();
		checkScore();
		checkTime();
		
		
		
		//System.out.println("health = " + player.getHealth() + "   score =  " + player.getScore());
		
		

	}
	
	public void checkScore() {
		
		scoreLabel.setText("Score : "+player.getScore());
		lblHighscore.setText("Highscore : "+player.getHighScore());
		if(player.getScore() > player.getHighScore())
			player.updateHighScore();
		
	}
	
	
	public void checkHealth() {
		
		
		
		if(player.getHealth() == 3)
		{
			live1.setVisible(true);
			live2.setVisible(true);
			live3.setVisible(true);
			
		}
		else if(player.getHealth() == 2) {
			live1.setVisible(false);
		live2.setVisible(true);
		live3.setVisible(true);

		
		}
		
		else if(player.getHealth() == 1) {
			live1.setVisible(false);
		live2.setVisible(false);
		live3.setVisible(true);

		
		}
		else if(player.getHealth() <= 0)
		{
			live1.setVisible(false);
			live2.setVisible(false);
			live3.setVisible(false);
			endGame();
			
			
			
		
			
			

		}
		
	}
	
	

	public void checkTime() {
	
		c++;
			if(c==8) {
				c=0;

			
			secondspassed++;
			
			if((secondspassed % 60)==0) {
				displayedMinutes++;
			secondspassed=0;	
			}
			//System.out.println(""+displayedMinutes+":"+secondspassed);
			
			lblTime.setText(""+displayedMinutes+":"+secondspassed);
			
				
			
		
			}
		
	}
	

	
	public  void endGame() {
		gover.setVisible(true);

		
t.stop();
		running = false;
	
		
	//	System.out.println(t.isRunning());

	
		//if(gover.isYesOption()) {
			//System.out.println("sone");		
			
		player.setHealth(3);
		player.setScore(0);
		gameObjects.clear();
		secondspassed = 0 ;
		  displayedMinutes =0 ;
		
		//gover.setYesOption(false);



	//	}
		
		
	}
}
