package tanks.model;

import java.awt.image.BufferedImage;

public class Projectile extends GameObject {
	private int damage;

	public Projectile(BufferedImage img, int x, int y, int z, int d, int s, int dmg) {
		super(img, x, y, z, true, s);
		this.setDamage(dmg);
	}
	
	public int getDamage(GameObject go){
		if(go instanceof Wall){
			return 0;
		} else if(go instanceof Crate){
			return 1;
		} else {
			return damage;
		}
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}

}
