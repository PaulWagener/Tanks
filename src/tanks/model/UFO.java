package tanks.model;

import java.awt.image.BufferedImage;

public class UFO extends GameObject {

	private int health;
	
	public UFO(BufferedImage img, int x, int y, int z, int sp, int h) {
		super(img, x, y, z, true, sp);
		health = h;
	}

	public int getHealth() {return health;}
	public void setHealth(int health) {this.health = health;}
	public void damageUFO(int damage) {health -= damage;}
	public boolean getAlive() {
		if(health <= 0) {return false;}
		return true;
	}
	
	

}
