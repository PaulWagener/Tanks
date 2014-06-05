package tanks.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import tanks.controller.Controller;
import tanks.model.Wall;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {

	private Controller controller;
	
	public FieldPanel(Controller con) {
		setPreferredSize(new Dimension(600, 600));
		controller = con;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(controller.getBackground(), 0, 0, null);
		for(Wall w:controller.getWalls()) {
			
		}
	}
	
}
