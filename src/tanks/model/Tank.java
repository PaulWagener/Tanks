package tanks.model;

import java.awt.image.BufferedImage;

public class Tank extends GameObject {
	private int reload;
	private Turret turret;

	public Tank(BufferedImage tank, BufferedImage turret, int x, int y, int z, int sp) {
		super(tank, x, y, z, true, sp);
		this.turret = new Turret(turret, x, y, z);
	}

	public int getReload() {
		return reload;
	}

	public void setReload(int reload) {
		this.reload = reload;
	}
	
	public Turret getTurret() {return turret;}

}
