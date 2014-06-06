package tanks.model;

import java.awt.image.BufferedImage;

public class Tank extends GameObject {
	private int reload;

	public Tank(BufferedImage img, int x, int y, int z, int sp) {
		super(img, x, y, z, true, sp);
	}

	public int getReload() {
		return reload;
	}

	public void setReload(int reload) {
		this.reload = reload;
	}

}
