package tower;

import bullet.Dart;
import logic.GameLogic;
import resource.ImageManager.Images;

public class DartShooter extends Tower {

	public static final String NAME = "Dart Shooter";
	public static final int BASE_PRICE = 300;

	public DartShooter(double x, double y) {

		super(Images.DARTSHOOTER, x, y, 800);
		this.setAtkRange(200);
		this.setPrice(300);

	}

	@Override
	public void shoot() {
		
		GameLogic.getBulletInField().add(new Dart(getPos().getX(), getPos().getY(), degrees));

	}

}
