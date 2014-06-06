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
import tanks.model.UFO;
import tanks.model.Wall;

public class Controller implements Runnable, MouseListener, KeyListener {
	
	private final int FPS = 60;
	
	private Thread 				thread;
	private Tank				tank;
	private UFO					ufo;
	private List<Crate>			crates;
	private List<Projectile>	projectiles;
	private List<Wall>			walls;
	
	private BufferedImage		backgroundImage, wallImage, crateImage, tankImage, ufoImage, tankTurretImage, turretImage;
	private FieldPanel panel;
	
	public Controller() {
		// Load images
		try {
			tankTurretImage	= ImageIO.read(getClass().getResourceAsStream("/tank+turret.png"));
			backgroundImage	= ImageIO.read(getClass().getResourceAsStream("/background.png"));
			wallImage		= ImageIO.read(getClass().getResourceAsStream("/wall.png"));
			crateImage		= ImageIO.read(getClass().getResourceAsStream("/crate.png"));
			ufoImage		= ImageIO.read(getClass().getResourceAsStream("/ufo.png"));
			turretImage		= ImageIO.read(getClass().getResourceAsStream("/turret.png"));
			tankImage		= ImageIO.read(getClass().getResourceAsStream("/tank.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		thread 		= new Thread(this);
		tank		= new Tank(tankImage, turretImage, 100, 100, 0, 10);
		ufo			= new UFO(ufoImage, 200, 200, 0, 15, 100);
		crates		= new ArrayList<Crate>();
		walls		= new ArrayList<Wall>();
		projectiles	= new ArrayList<Projectile>();

		thread.start();
	}
	
	private void createField() {
		// Create all crates
		
		// Create all tanks
		
	}

	private void updateTank() {
		// Update position of red attacker tank

		// Update position of turret

		// Shoot projectiles

	}

	private void updateUfo() {
		// Update position of ufo
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
				updateTank();
				updateUfo();
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
	
	public List<Crate> getCrates() 				{return crates;}
	public List<Projectile> getProjectiles() 	{return projectiles;}
	public List<Wall> getWalls() 				{return walls;}
	
	public BufferedImage getBackgroundImage()	{return backgroundImage;}
	public BufferedImage getWallImage()			{return wallImage;}
	public BufferedImage getCrateImage()		{return crateImage;}
	public BufferedImage getTurretImage()		{return turretImage;}
	public BufferedImage getTankImage()			{return tankImage;}
	public BufferedImage getUfoImage()			{return ufoImage;}
	public BufferedImage getTankTurretImage()	{return tankTurretImage;}
	
	public UFO getUfo()							{return ufo;}
	public Tank getTank() 						{return tank;}
	
	public void setPanel(FieldPanel panel) {
		this.panel = panel;
	}
	
}
