package de.hhu.bomberman;

<<<<<<< HEAD
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

=======


import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

>>>>>>> 7753813ff6f856747312f564c94c8db6575dacea
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class main extends JFrame {

	final int walkVal = 10;
	
	PlayerLabel playerLabel; // player
	BombLabel bombLabel;
	JPanel mainPanel;	// spielfeld
	
	Point aktPosition = new Point();
	
	final ImageIcon playerDownIcon = new ImageIcon("src/de/hhu/bomberman/images/down.gif");
	final ImageIcon playerLeftIcon = new ImageIcon("src/de/hhu/bomberman/images/left.gif");
	final ImageIcon playerRightIcon = new ImageIcon("src/de/hhu/bomberman/images/right.gif");
	final ImageIcon playerUpIcon = new ImageIcon("src/de/hhu/bomberman/images/up.gif");
//	final ImageIcon bombIcon = new ImageIcon("src/de/hhu/bomberman/bombe.gif");
	
	public main() {
		mainPanel = GUIcreateGamePanel();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent wEvent) {
				System.exit(0);
			}
		});
		this.getContentPane().add(mainPanel);
		this.setLocation(100, 100);
		this.setSize(750, 570);
		this.setTitle("Game V0.01");
		this.setVisible(true);
		
		new StartScreen();
		mainPanel.grabFocus();
	}
	
	public JPanel GUIcreateGamePanel() { // initialisierung spielfeld
		mainPanel = new GamePanel(Toolkit.getDefaultToolkit().getImage("src/de/hhu/bomberman/images/spielfeld.jpg"));
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 55, 55)); // anfang des layoutmanagers / position der figur
		mainPanel.add(GUIcreatePlayer());
		
		bombLabel = new BombLabel();
		mainPanel.add(bombLabel);
		bombLabel.setLocation(aktPosition);
		repaint();
		
		aktPosition.setLocation(new Point(playerLabel.getX(), playerLabel.getY()));

		mainPanel.addKeyListener(new KeyAdapter() { // key lauscher, wartet auf tastenbefehle
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent kEvent) {
				if(kEvent.getKeyCode() == kEvent.VK_LEFT) {
					playerLabel.setIcon(playerLeftIcon);
					if(playerLabel.getX() > 50 && playerLabel.getX() < 690) // abfrage wo sich der player befindet
						playerLabel.setLocation(playerLabel.getX() - walkVal, playerLabel.getY()); // bewegung
					// linksbewegung
				} else if(kEvent.getKeyCode() == kEvent.VK_RIGHT) {
					playerLabel.setIcon(playerRightIcon);
					if(playerLabel.getX() > 40 && playerLabel.getX() < 700)
						playerLabel.setLocation(playerLabel.getX() + walkVal, playerLabel.getY());
					// rechtsbewegung
				} else if(kEvent.getKeyCode() == kEvent.VK_DOWN) {
					playerLabel.setIcon(playerDownIcon);
					if(playerLabel.getY() > 40 && playerLabel.getY() < 500)
						playerLabel.setLocation(playerLabel.getX(), playerLabel.getY() + walkVal);
					// runter
				} else if(kEvent.getKeyCode() == kEvent.VK_UP) {
					playerLabel.setIcon(playerUpIcon);
					if(playerLabel.getY() > 50 && playerLabel.getY() < 490)	
						playerLabel.setLocation(playerLabel.getX(), playerLabel.getY() - walkVal);
					// hoch
				} else if(kEvent.getKeyCode() == kEvent.VK_SPACE) {
//					bombLabel.setVisible(true);
					bombLabel.setLocation(aktPosition);
				}
				repaint(); // neuzeichnen
				aktPosition.setLocation(new Point(playerLabel.getX(), playerLabel.getY()));
			}
		});

		return mainPanel;
	}
	
	public JLabel GUIcreatePlayer() {
		playerLabel = new PlayerLabel(playerDownIcon);
		
		
		return playerLabel;
	}
	
	public static void main(final String[] args) {
		new main();
	}
	
}

@SuppressWarnings("serial")
class BombLabel extends JLabel {
	final static ImageIcon bombIcon = new ImageIcon("src/de/hhu/bomberman/images/bombe.png");
	
	public BombLabel() {
		super(bombIcon);
	}
<<<<<<< HEAD
}

=======
>>>>>>> 7753813ff6f856747312f564c94c8db6575dacea
