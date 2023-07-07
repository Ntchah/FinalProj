package bullet;

import resource.ImageManager.Images;

public class Shuriken extends Bullet {

	public Shuriken(double x, double y, double angle) {
		super(Images.SHURIKEN, x, y, angle);
		this.setBulletSpeed(10);

	}

}