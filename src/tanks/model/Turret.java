package tanks.model;

import java.awt.image.BufferedImage;

public class Turret extends GameObject {

	public Turret(BufferedImage img, int x, int y, int z) {
		super(img, x, y, z, true, 0);
	}

}
