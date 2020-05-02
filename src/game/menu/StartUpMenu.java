package game.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import game.data.Sound;
import game.data.XmlFile;
import game.gfx.GameFrame;
import game.level.ILevel;
import game.level.LevelFctory;

public class StartUpMenu extends JFrame {

	private JPanel contentPane;
	private JLabel highscoreLabel;
	private XmlFile file;
	private LevelFctory levelFctory;
	private ILevel choosenLevel;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public StartUpMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		file = new XmlFile();
		levelFctory = new LevelFctory();
		JLabel lblChooseLevel = new JLabel("Choose level");
		lblChooseLevel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChooseLevel.setForeground(Color.WHITE);
		lblChooseLevel.setBounds(148, 333, 147, 23);
		contentPane.add(lblChooseLevel);
		Sound s = new Sound();
		s.playMusic("menu.wav");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(291, 333, 71, 23);
		contentPane.add(comboBox);
		
		if(comboBox.getSelectedIndex() == 0)
		choosenLevel=levelFctory.createLevel(0);
		
		else	if(comboBox.getSelectedIndex() == 1)
			choosenLevel=levelFctory.createLevel(1);
		
		else	if(comboBox.getSelectedIndex() == 2)
			choosenLevel=levelFctory.createLevel(2);
		
		
		
		
		
		
		
		JLabel lblStartGame = new JLabel("Start Game");
		lblStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GameFrame d=new GameFrame(choosenLevel);
				d.setVisible(true);
				setVisible(false);
				
			}
		});
		lblStartGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartGame.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStartGame.setBackground(Color.WHITE);
		lblStartGame.setForeground(Color.WHITE);
		lblStartGame.setBounds(127, 279, 147, 52);
		contentPane.add(lblStartGame);
		
		JLabel lblShowHighscore = new JLabel("Highscore");
		lblShowHighscore.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblShowHighscore.setForeground(Color.WHITE);
		lblShowHighscore.setBounds(148, 374, 130, 23);
		contentPane.add(lblShowHighscore);
		
		highscoreLabel = new JLabel("");
		highscoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highscoreLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		highscoreLabel.setForeground(Color.WHITE);
		highscoreLabel.setBounds(301, 374, 40, 23);
		highscoreLabel.setText(""+file.getHighscore());
		contentPane.add(highscoreLabel);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(StartUpMenu.class.getResource("/textures/menuu.png")));
		label.setBounds(0,0, 700,500 );
		contentPane.add(label);
		
		
		
		
		
		
		
		
		
		
	}
}
