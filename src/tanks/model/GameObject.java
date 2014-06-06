package tanks.model;

import java.awt.image.BufferedImage;

public abstract class GameObject {

	private int 			x_coordination,
							y_coordination,
							z_rotation,
							speed;
	private BufferedImage 	image;
	private Boolean			solid;
	
	public GameObject(BufferedImage img, int x, int y, int z, boolean so, int sp) {
		this.image = img;
		this.setX_coordination(x);
		this.setY_coordination(y);;
		this.setZ_rotation(z);
		this.setSolid(so);
		this.setSpeed(sp);
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
		this.z_rotation = z_rotation % 360;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public Boolean getSolid() {
		return solid;
	}

	public void setSolid(Boolean solid) {
		this.solid = solid;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
