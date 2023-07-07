package bullet;

import resource.ImageManager.Images;

public class SniperBullet extends Bullet {

	public SniperBullet(double x, double y, double angle) {
		super(Images.SNIPERBULLET, x, y, angle);
		this.setBulletSpeed(50);
	}
	
	
}
