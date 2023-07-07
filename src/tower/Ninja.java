package tower;

import bullet.Shuriken;
import logic.GameLogic;
import resource.ImageManager.Images;

public class Ninja extends Tower {

	public static final String NAME = "Ninja";
	public static final int BASE_PRICE = 400;

	public Ninja(double x, double y) {

		super(Images.NINJA, x, y, 900);
		this.setAtkRange(220);
		this.setPrice(400);

	}
	
	@Override
	public void shoot() {

		GameLogic.getBulletInField().add(new Shuriken(getPos().getX(), getPos().getY(), degrees));

	}

}
