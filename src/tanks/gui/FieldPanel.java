package tanks.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import tanks.controller.Controller;
import tanks.model.Crate;
import tanks.model.GameObject;
import tanks.model.Projectile;
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
		g2d.drawImage(controller.getBackgroundImage(), 0, 0, null);
		for(Wall w:controller.getWalls()) {
			draw(g2d, w);
		}
		for(Crate c:controller.getCrates()) {
			draw(g2d, c);
		}
		
		draw(g2d, controller.getTank());
		draw(g2d, controller.getTank().getTurret());
		draw(g2d, controller.getUfo());
		
		for(Projectile p:controller.getProjectiles()) {
			draw(g2d, p);
		}
	}

	private void draw(Graphics2D g, GameObject gameObject) {
		AffineTransform at = new AffineTransform();
		int center_x = gameObject.getImage().getWidth() / 2;
		int center_y = gameObject.getImage().getHeight() / 2;

		at.translate(gameObject.getX_coordination() - center_x, gameObject.getY_coordination() - center_y);
		at.rotate(gameObject.getZ_rotation() / 180.0 * Math.PI, center_x, center_y);

		g.drawImage(gameObject.getImage(), at, null);
	}
	
}
