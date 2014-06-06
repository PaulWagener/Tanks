package tanks.model;

import java.awt.image.BufferedImage;

public class Crate extends GameObject {
	private int 	maxDamage,
					currentDamage;

	public Crate(BufferedImage img, int x, int y, int m) {
		super(img, x, y, 0, false, 0);
		this.setMaxDamage(m);
		this.currentDamage = 0;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getCurrentDamage() {
		return currentDamage;
	}

	public void damage(int dmg) {
		this.currentDamage = dmg + this.currentDamage;
	}
	
	public boolean alive(){
		if(this.getMaxDamage() == this.getCurrentDamage())
			return false;
		else 
			return true;
	}

}
