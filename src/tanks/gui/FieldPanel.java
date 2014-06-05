package tanks.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import tanks.controller.Controller;
import tanks.model.Crate;
import tanks.model.Projectile;
import tanks.model.Tank;
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
			g2d.drawImage(w.getImage(), w.getX_coordination(), w.getY_coordination(), null);
		}
		for(Crate c:controller.getCrates()) {
			g2d.drawImage(c.getImage(), c.getX_coordination(), c.getY_coordination(), null);
		}
		for(Tank t:controller.getTanks()) {
			g2d.drawImage(t.getImage(), t.getX_coordination(), t.getY_coordination(), null);
		}
		for(Projectile p:controller.getProjectiles()) {
			g2d.drawImage(p.getImage(), p.getX_coordination(), p.getY_coordination(), null);
		}
	}
	
}
