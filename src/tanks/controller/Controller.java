package tanks.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import tanks.gui.FieldPanel;
import tanks.model.Crate;
import tanks.model.Projectile;
import tanks.model.Tank;
import tanks.model.Wall;

public class Controller implements Runnable, MouseListener, KeyListener {
	
	private final int FPS = 60;
	
	private Thread 				thread;
	private Tank[]				tanks;
	private List<Crate>			crates;
	private List<Projectile>	projectiles;
	private List<Wall>			walls;
	
	private BufferedImage		background, wall, crate;
	private FieldPanel panel;
	
	public Controller() {
		thread 		= new Thread(this);
		tanks		= new Tank[] {
				new Tank(null, 8, 8, 0, 10, 100), 
				new Tank(null, 16, 16, 0, 10, 100)
				};
		crates		= new ArrayList<Crate>();
		walls		= new ArrayList<Wall>();
		projectiles	= new ArrayList<Projectile>();
		try {
			background	= ImageIO.read(getClass().getResourceAsStream("/background.png"));
			wall		= ImageIO.read(getClass().getResourceAsStream("/background.png"));
			crate		= ImageIO.read(getClass().getResourceAsStream("/background.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		thread.start();
	}
	
	private void createField() {
		// Create all crates
		
		// Create all tanks
		
	}

	private void updateTank1() {
		// Update position of red attacker tank

		// Update position of turret

		// Shoot projectiles

	}

	private void updateTank2() {
		// Update position of blue defender tank
	}

	private void updateProjectiles() {
		// Update position of all projectiles

		// Collision detection with crates

		// Collision detection with defender tank
	}

	public void run() {
		// Game loop
		while(true) {
		
			try {
				updateTank1();
				updateTank2();
				updateProjectiles();

				// Draw
				if(panel != null)
					panel.repaint();

				Thread.sleep(1000/FPS);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) 		{}

	public void keyReleased(KeyEvent e) 	{}

	public void keyTyped(KeyEvent e) 		{}

	public void mouseClicked(MouseEvent e) 	{}

	public void mouseEntered(MouseEvent e) 	{}

	public void mouseExited(MouseEvent e) 	{}

	public void mousePressed(MouseEvent e) 	{}

	public void mouseReleased(MouseEvent e) {}
	
	public Tank[] getTanks() 					{return tanks;}
	public List<Crate> getCrates() 				{return crates;}
	public List<Projectile> getProjectiles() 	{return projectiles;}
	public List<Wall> getWalls() 				{return walls;}
	
	public BufferedImage getBackground()		{return background;}
	public BufferedImage getWall()				{return wall;}
	public BufferedImage getCrate()				{return crate;}

	public void setPanel(FieldPanel panel) {
		this.panel = panel;
	}
	
}
