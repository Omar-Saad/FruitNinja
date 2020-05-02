package game.gfx;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.level.ILevel;
import game.level.LevelFctory;
import game.objects.GamePanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	private GamePanel gamPanel;
	private JPanel contentPane;

	

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GameFrame(ILevel level) {
		setTitle("Fruit ninja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 contentPane.setLayout(null);
gamPanel = new GamePanel(level); 
gamPanel.setBounds(0, 0, 700, 500);
contentPane.add(gamPanel);
		
		


	}
	
	
	
	
	
	
	
	
	
	
	
}
