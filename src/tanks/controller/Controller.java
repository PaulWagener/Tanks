package tanks.controller;

import java.util.ArrayList;
import java.util.List;

import tanks.gui.FieldPanel;
import tanks.model.Crate;
import tanks.model.Projectile;
import tanks.model.Tank;
import tanks.model.Wall;

public class Controller implements Runnable {
	
	private final int FPS = 60;
	
	private FieldPanel 			fieldPanel;
	private Thread 				thread;
	private Tank[]				tanks;
	private List<Crate>			crates;
	private List<Projectile>	projectiles;
	private List<Wall>			walls;
	
	public Controller(FieldPanel fp) {
		fieldPanel 	= fp;
		thread 		= new Thread(this);
		tanks		= new Tank[] {
				new Tank(null, 8, 8, 0, 10, 100), 
				new Tank(null, 16, 16, 0, 10, 100)
				};
		crates		= new ArrayList<Crate>();
		walls		= new ArrayList<Wall>();
		projectiles	= new ArrayList<Projectile>();
		thread.start();
	}
	
	private void createField() {
		// Create all crates
		
		// Create all tanks
		
	}

	public void run() {
		while(true) {
			fieldPanel.repaint();		
			try {
				Thread.sleep(1000/FPS);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
