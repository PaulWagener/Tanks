package tanks.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;

import tanks.gui.FieldPanel;
import tanks.model.Crate;
import tanks.model.Projectile;
import tanks.model.Tank;
import tanks.model.UFO;
import tanks.model.Wall;

public class Controller implements Runnable, MouseInputListener, KeyListener {
	
	private final int FPS = 60;
	
	private Thread 				thread;
	private Tank				tank;
	private UFO					ufo;
	private List<Crate>			crates;
	private List<Projectile>	projectiles;
	private List<Wall>			walls;
	private int					aim_x;
	private int					aim_y;
	private int					aim_rotation;
	
	private BufferedImage		backgroundImage, wallImage, crateImage, tankImage, ufoImage, tankTurretImage, turretImage, aimImage;
	private FieldPanel panel;
	private boolean[]			tankControls, ufoControls;
	
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
			aimImage		= ImageIO.read(getClass().getResourceAsStream("/aim.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		thread 		= new Thread(this);
		tank		= new Tank(tankImage, turretImage, 100, 100, 0, 4);
		ufo			= new UFO(ufoImage, 200, 200, 0, 6, 100);
		crates		= new ArrayList<Crate>();
		walls		= new ArrayList<Wall>();
		projectiles	= new ArrayList<Projectile>();
		
		tankControls = new boolean[] {false, false, false, false};
		ufoControls	 = new boolean[] {false, false, false, false};

		thread.start();
	}

	private void updateTank() {
		// Update position of red attacker tank
//		if(tankControls[0]) tank.setY_coordination(tank.getY_coordination() - tank.getSpeed());
//		if(tankControls[2]) tank.setY_coordination(tank.getY_coordination() + tank.getSpeed());
//		if(tankControls[1]) tank.setX_coordination(tank.getX_coordination() - tank.getSpeed());
//		if(tankControls[3]) tank.setX_coordination(tank.getX_coordination() + tank.getSpeed());
		if(tankControls[0]) {
			int newX = tank.getX_coordination() + (int)(Math.cos(Math.toRadians(tank.getZ_rotation() - 90)) * tank.getSpeed());
			int newY = tank.getY_coordination() + (int)(Math.sin(Math.toRadians(tank.getZ_rotation() - 90)) * tank.getSpeed());
			if(newX >= 20 && newX <= FieldPanel.WIDTH - 20) {tank.setX_coordination(newX);}
			if(newY >= 20 && newY <= FieldPanel.HEIGHT - 20) {tank.setY_coordination(newY);}
		}
		if(tankControls[2]) {
			int newX = tank.getX_coordination() - (int)(Math.cos(Math.toRadians(tank.getZ_rotation() - 90)) * tank.getSpeed());
			int newY = tank.getY_coordination() - (int)(Math.sin(Math.toRadians(tank.getZ_rotation() - 90)) * tank.getSpeed());
			if(newX >= 20 && newX <= FieldPanel.WIDTH - 20) {tank.setX_coordination(newX);}
			if(newY >= 20 && newY <= FieldPanel.HEIGHT - 20) {tank.setY_coordination(newY);}
		}
		
		if(tankControls[1]) tank.setZ_rotation(tank.getZ_rotation() - 4);
		if(tankControls[3]) tank.setZ_rotation(tank.getZ_rotation() + 4);
		// Update position of turret
		tank.getTurret().setX_coordination(tank.getX_coordination());
		tank.getTurret().setY_coordination(tank.getY_coordination());
		tank.getTurret().setZ_rotation((int)(Math.atan2(tank.getY_coordination() - aim_y, tank.getX_coordination() - aim_x) / Math.PI * 180.0) + 90);
		// Shoot projectiles

	}

	private void updateUfo() {
		if(ufoControls[0]) ufo.setY_coordination(ufo.getY_coordination() - ufo.getSpeed());
		if(ufoControls[2]) ufo.setY_coordination(ufo.getY_coordination() + ufo.getSpeed());
		if(ufoControls[1]) ufo.setX_coordination(ufo.getX_coordination() - ufo.getSpeed());
		if(ufoControls[3]) ufo.setX_coordination(ufo.getX_coordination() + ufo.getSpeed());
		ufo.setZ_rotation(ufo.getZ_rotation() - 4);
	}

	private void updateProjectiles() {
		// Update position of all projectiles

		// Collision detection with crates

		// Collision detection with defender tank
	}

	private void updateAim() {
		// Cool little rotation animation
		aim_rotation++;
	}

	public void run() {
		// Game loop
		while(true) {
		
			try {
				updateTank();
				updateUfo();
				updateProjectiles();
				updateAim();

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

	public void keyPressed(KeyEvent e) 		{
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) 		ufoControls[0] = true;
		if(code == KeyEvent.VK_A) 		ufoControls[1] = true;
		if(code == KeyEvent.VK_S) 		ufoControls[2] = true;
		if(code == KeyEvent.VK_D) 		ufoControls[3] = true;
		
		if(code == KeyEvent.VK_UP) 		tankControls[0] = true;
		if(code == KeyEvent.VK_LEFT) 	tankControls[1] = true;
		if(code == KeyEvent.VK_DOWN) 	tankControls[2] = true;
		if(code == KeyEvent.VK_RIGHT) 	tankControls[3] = true;
	}

	public void keyReleased(KeyEvent e) 	{
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) 		ufoControls[0] = false;
		if(code == KeyEvent.VK_A) 		ufoControls[1] = false;
		if(code == KeyEvent.VK_S) 		ufoControls[2] = false;
		if(code == KeyEvent.VK_D) 		ufoControls[3] = false;
		
		if(code == KeyEvent.VK_UP) 		tankControls[0] = false;
		if(code == KeyEvent.VK_LEFT) 	tankControls[1] = false;
		if(code == KeyEvent.VK_DOWN) 	tankControls[2] = false;
		if(code == KeyEvent.VK_RIGHT) 	tankControls[3] = false;
	}

	
	
	public void keyTyped(KeyEvent e) 		{}
	public void mouseClicked(MouseEvent e) 	{}
	public void mouseEntered(MouseEvent e) 	{}
	public void mouseExited(MouseEvent e) 	{}
	public void mousePressed(MouseEvent e) 	{}
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		aim_x = e.getX();
		aim_y = e.getY();
	}

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
	public BufferedImage getAimImage()			{return aimImage;}
	
	public UFO getUfo()							{return ufo;}
	public Tank getTank() 						{return tank;}
	
	public void setPanel(FieldPanel panel) {
		panel.addMouseMotionListener(this);
		this.panel = panel;
	}

	public int getAimX() {
		return aim_x;
	}

	public int getAimY() {
		return aim_y;
	}
	
	public int getAimRotation() {
		return aim_rotation;
	}

}
