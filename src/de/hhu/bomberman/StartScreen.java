package de.hhu.bomberman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartScreen extends JDialog {
	
	File imageFile = new File("src/de/hhu/bomberman/images/startscreen.jpg");
	ImageIcon startImage = new ImageIcon("src/de/hhu/bomberman/images/startscreen.jpg");
	
	JButton startButton;
	
	public StartScreen() {
		Dimension dim = new Dimension(startImage.getIconWidth(), startImage.getIconHeight());
		GamePanel mainPanel = new GamePanel(Toolkit.getDefaultToolkit().getImage("src/de/hhu/bomberman/images/startscreen.jpg"));
		mainPanel.setLayout(new BorderLayout());
		
		startButton = new JButton("Start") {
			public Dimension getPreferredSize() {
				return new Dimension(80, 20);
			}
		};
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent aEvent) {
				dispose();
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.getContentPane().add(mainPanel);
		this.setUndecorated(true);
		this.setSize(dim);
		this.setVisible(true);
		this.setModal(true);
		this.setLocation(100, 100);
	}