package tanks.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import tanks.controller.Controller;
import tanks.model.Crate;
import tanks.model.GameObject;
import tanks.model.Projectile;
import tanks.model.Tank;
import tanks.model.Wall;

@SuppressWarnings("serial")
public class FieldPanel extends JPanel {

	private Controller controller;
	
	public FieldPanel(Controller con) {
		setPreferredSize(new Dimension(600, 600));
		controller = con;

		// Hide cursor
		setCursor(getToolkit().createCustomCursor(
	            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
	            "null"));
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
		draw(g2d, controller.getUfo());
		
		for(Projectile p:controller.getProjectiles()) {
			draw(g2d, p);
		}

		// Draw aim
		draw(g2d, controller.getAimX(), controller.getAimY(), controller.getAimRotation(), controller.getAimImage());
	}

	private void draw(Graphics2D g, GameObject gameObject) {
		draw(g, gameObject.getX_coordination(), gameObject.getY_coordination(), gameObject.getZ_rotation(), gameObject.getImage());
	}

	private void draw(Graphics2D g, int x, int y, int rotation, BufferedImage image) {
		AffineTransform at = new AffineTransform();
		int center_x = image.getWidth() / 2;
		int center_y = image.getHeight() / 2;

		at.translate(x - center_x, y - center_y);
		at.rotate(rotation / 180.0 * Math.PI, center_x, center_y);

		g.drawImage(image, at, null);
	}
	
}
