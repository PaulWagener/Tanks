package tanks.model;

import java.awt.image.BufferedImage;

public class Crate extends GameObject {
	private int 	maxDamage,
					currentDamage;

	public Crate(BufferedImage img, int x, int y, int m) {
		super(img, x, y, 0, false, 0);
		this.setMaxDamage(m);
		this.setCurrentDamage(0);
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

	public void setCurrentDamage(int currentDamage) {
		this.currentDamage = currentDamage;
	}

}
