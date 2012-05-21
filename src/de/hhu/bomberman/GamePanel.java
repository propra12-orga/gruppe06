package de.hhu.bomberman;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class GamePanel extends JPanel { // klasse wegen hintergrundgrafik, >> ergänzen
	 
    private Image image;

    GamePanel(Image image) {
        this.image = image;
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
        
    }
}