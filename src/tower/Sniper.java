package tower;

import bullet.SniperBullet;
import logic.GameLogic;
import resource.ImageManager.Images;

public class Sniper extends Tower {

	public static final String NAME = "Sniper";
	public static final int BASE_PRICE = 350;

	public Sniper(double x, double y) {

		super(Images.SNIPER, x, y, 1200);
		this.setAtkRange(10000);
		this.setPrice(350);

	}

	@Override
	public void shoot() {

		GameLogic.getBulletInField().add(new SniperBullet(getPos().getX(), getPos().getY(), degrees));

	}

}
