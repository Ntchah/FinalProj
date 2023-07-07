package bullet;

import resource.ImageManager.Images;

public class Dart extends Bullet {

	public Dart(double x, double y, double angle) {
		super(Images.DART, x, y, angle);
		this.setBulletSpeed(5);
	}

}
