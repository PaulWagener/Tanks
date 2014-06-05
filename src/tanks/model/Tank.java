package tanks.model;

import java.awt.image.BufferedImage;

public class Tank extends GameObject
{
	private int health;
	private int reload;
	
	public Tank(BufferedImage img, int x, int y, int z, int sp, int health)
	{
		super(img, x, y, z, true, sp);
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getReload()
	{
		return reload;
	}

	public void setReload(int reload)
	{
		this.reload = reload;
	}

}
