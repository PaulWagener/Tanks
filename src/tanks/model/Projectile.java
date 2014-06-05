package tanks.model;

import java.awt.image.BufferedImage;

public class Projectile extends GameObject {
	private int damage;

	public Projectile(BufferedImage img, int x, int y, int z, int d, int s) {
		super(img, x, y, z, true, s);
	}
	
	public int getDamage(GameObject go){
		if(go instanceof Wall){
			return 0;
		}else {
			return damage;
		}
	}

}
