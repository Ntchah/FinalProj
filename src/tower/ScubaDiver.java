package tower;

import bullet.Dart;
import logic.GameLogic;
import resource.ImageManager.Images;

public class ScubaDiver extends Tower {
	public static final String NAME = "Scuba Diver";
	public static final int BASE_PRICE = 400;

	public ScubaDiver(double x, double y) {

		super(Images.SCUBADIVER, x, y, 800);
		this.setAtkRange(200);
		this.setPrice(400);

	}

	@Override
	public void shoot() {

		GameLogic.getBulletInField().add(new Dart(getPos().getX(), getPos().getY(), degrees));

	}

}
