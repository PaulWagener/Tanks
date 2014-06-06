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

	private Thread thread;
	private Tank tank;
	private UFO ufo;
	private List<Crate> crates;
	private List<Projectile> projectiles;
	private List<Wall> walls;

	private BufferedImage backgroundImage, wallImage, crateImage, tankImage,
			ufoImage, tankTurretImage, turretImage;
	private FieldPanel panel;
	public static final int FIELDWIDTH = 600;
	public static final int FIELDHEIGHT = 600;
	public static final int BLOCKSIZE = 40;

	public Controller() {
		// Load images
		try {
			tankTurretImage = ImageIO.read(getClass().getResourceAsStream(
					"/tank+turret.png"));
			backgroundImage = ImageIO.read(getClass().getResourceAsStream(
					"/background.png"));
			wallImage = ImageIO.read(getClass()
					.getResourceAsStream("/wall.png"));
			crateImage = ImageIO.read(getClass().getResourceAsStream(
					"/crate.png"));
			ufoImage = ImageIO.read(getClass().getResourceAsStream("/ufo.png"));
			turretImage = ImageIO.read(getClass().getResourceAsStream(
					"/turret.png"));
			tankImage = ImageIO.read(getClass()
					.getResourceAsStream("/tank.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		thread = new Thread(this);
		tank = new Tank(tankImage, 8, 8, 0, 10);
		ufo = new UFO(ufoImage, 200, 200, 0, 15, 100);
		crates = new ArrayList<Crate>();
		walls = new ArrayList<Wall>();
		projectiles = new ArrayList<Projectile>();

		this.createField();
		thread.start();
	}

	private void createField() {
		// Create all crates
		this.createWalls();
		this.createObjectsInField();
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
		while (true) {

			try {
				updateTank();
				updateUfo();
				updateProjectiles();

				// Draw
				if (panel != null)
					panel.repaint();

				Thread.sleep(1000 / FPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public List<Crate> getCrates() {
		return crates;
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}

	public BufferedImage getWallImage() {
		return wallImage;
	}

	public BufferedImage getCrateImage() {
		return crateImage;
	}

	public BufferedImage getTurretImage() {
		return turretImage;
	}

	public BufferedImage getTankImage() {
		return tankImage;
	}

	public BufferedImage getUfoImage() {
		return ufoImage;
	}

	public BufferedImage getTankTurretImage() {
		return tankTurretImage;
	}

	public UFO getUfo() {
		return ufo;
	}

	public Tank getTank() {
		return tank;
	}

	public void setPanel(FieldPanel panel) {
		this.panel = panel;
	}

	private void createObjectsInField() {

		int[] xCrateCoordinates = { 4, 5, 9, 10, 4, 10, 2, 7, 12, 2, 6, 7, 8,
				12, 2, 7, 12, 4, 10, 4, 5, 9, 10 };
		int[] yCrateCoordinates = { 2, 2, 2, 2, 4, 4, 6, 6, 6, 7, 7, 7, 7, 7,
				8, 8, 8, 10, 10, 12, 12, 12, 12 };

		int[] xWallCoordinates = { 6, 7, 8, 4, 10, 4, 10, 4, 10, 4, 10, 4, 10,
				6, 7, 8 };
		int[] yWallCoordinates = { 2, 2, 2, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 12,
				12, 12 };

		//creating crates
		for (int i = 0; i < xCrateCoordinates.length; i++) {
			crates.add(new Crate(this.getCrateImage(), xCrateCoordinates[i] * BLOCKSIZE + 20, yCrateCoordinates[i] * BLOCKSIZE + 20, 0));
		}
		//creating field walls
		for (int i = 0; i < xWallCoordinates.length; i++) {
			walls.add(new Wall(this.getWallImage(), xWallCoordinates[i] * BLOCKSIZE + 20, yWallCoordinates[i] * BLOCKSIZE + 20, 0));
		}
	}

	private void createWalls() {
		int x = 0;
		int y = 0;

		// top row
		for (int i = 0; i < (FIELDWIDTH / 40) + 1; i++) {
			walls.add(new Wall(this.getWallImage(), x * BLOCKSIZE, y * BLOCKSIZE, 0));
			x++;
		}

		// left column
		x = 0;
		for (int i = 0; i < (FIELDHEIGHT / 40) + 1; i++) {
			walls.add(new Wall(this.getWallImage(), x * BLOCKSIZE, y * BLOCKSIZE, 0));
			y++;
		}

		// right column
		x = (FIELDWIDTH / 40);
		y = 0;
		for (int i = 0; i < (FIELDHEIGHT / 40) + 1; i++) {
			walls.add(new Wall(this.getWallImage(), x * BLOCKSIZE, y * BLOCKSIZE, 0));
			y++;
		}

		// bottom row
		y = (FIELDHEIGHT / 40);
		x = 0;
		for (int i = 0; i < (FIELDWIDTH / 40) + 1; i++) {
			walls.add(new Wall(this.getWallImage(), x * BLOCKSIZE, y * BLOCKSIZE, 0));
			x++;
		}

	}
}
