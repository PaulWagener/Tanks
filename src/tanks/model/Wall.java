package tanks.model;

import java.awt.image.BufferedImage;

public class Wall extends GameObject {

	public Wall(BufferedImage img, int x, int y, int z) {
		super(img, x, y, z, true);
	}
	
}
