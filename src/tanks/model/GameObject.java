package tanks.model;

import java.awt.image.BufferedImage;

public abstract class GameObject {

	private int 			x_coordination,
							y_coordination,
							z_rotation;
	private BufferedImage 	image;
	
	public GameObject(BufferedImage img, int x, int y, int z) {
		this.image = img;
		this.x_coordination = x;
		this.y_coordination = y;
		this.z_rotation = z;
	}

	public int getX_coordination() {
		return x_coordination;
	}

	public void setX_coordination(int x_coordination) {
		this.x_coordination = x_coordination;
	}

	public int getY_coordination() {
		return y_coordination;
	}

	public void setY_coordination(int y_coordination) {
		this.y_coordination = y_coordination;
	}

	public int getZ_rotation() {
		return z_rotation;
	}

	public void setZ_rotation(int z_rotation) {
		this.z_rotation = z_rotation;
	}

	public BufferedImage getImage() {
		return image;
	}

}
