package tower;

import resource.ImageManager;
import resource.ImageManager.Images;
import sharedObject.Entity;
import utility.Utility;
import utility.UtilityGUI;

import java.time.Duration;
import balloon.Balloon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Rotate;
import logic.GameLogic;

public abstract class Tower extends Entity {

	private double shootSpeed;
	private double atkRange;
	private int price;
	private int radius;
	protected double degrees;
	private long startTime;
	private Duration atkSpeed;
	private long remainingTime;

	public Tower(Images image, double x, double y, long shootSpeed) {

		super(image, x, y);
		this.setShootSpeed(shootSpeed);
		this.getPos().setCanMove(false);
		this.z = -100;
		radius = 10;
		degrees = -90;
		atkSpeed = Duration.ofMillis((long) shootSpeed);

		GameLogic.getTowerInField().add(this);

	}

	public double getShootSpeed() {
		return shootSpeed;
	}

	public void setShootSpeed(double shootSpeed) {
		this.shootSpeed = Math.max(1, shootSpeed);
	}

	public abstract void shoot();

	@Override
	public void update() {

		long elapsedTime = System.nanoTime() - startTime;
		remainingTime = atkSpeed.toNanos() - elapsedTime;
		for (Balloon balloon : GameLogic.getBalloonInField()) {
			if (Utility.getObjectDistance(this, balloon) <= getAtkRange()) {
				this.degrees = (int) Utility.turningDegree(this, balloon);
				if (remainingTime <= 0) {
					startTime = System.nanoTime();
					shoot();
					break;
				}
			}
		}

	}

	@Override
	public void draw(GraphicsContext gc) {
    
		ImageView imageView = new ImageView(ImageManager.getImage(image));
		Rotate rotate = new Rotate(degrees + 90, 30, 30);

		rotate.setPivotX(30);
		rotate.setPivotY(30);
		imageView.getTransforms().add(rotate);

		WritableImage rotatedImage = imageView.snapshot(null, null);

		gc.drawImage(UtilityGUI.makeTransparent(rotatedImage), getPos().getX() - radius, getPos().getY() - radius);

	}
	

	public double getAtkRange() {
		return atkRange;
	}

	public void setAtkRange(double atkRange) {
		this.atkRange = Math.max(0, atkRange);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
