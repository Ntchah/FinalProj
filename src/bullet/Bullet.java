package bullet;

import balloon.Balloon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Rotate;
import resource.ImageManager;
import resource.ImageManager.Images;
import sharedObject.Collidable;
import sharedObject.Entity;
import utility.UtilityGUI;
import logic.GameLogic;

public abstract class Bullet extends Entity implements Collidable {

	private int bulletSpeed;
	private int radius;
	private double angle;
	private boolean getHit;

	public Bullet(Images image, double x, double y, double angle) {

		super(image, x, y);
		this.z = -25;
		radius = 10;
		this.angle = angle;
		getHit = false;
		
		GameLogic.getBulletInField().add(this);
		GameLogic.addNewObject(this);
		GameLogic.getGameFlowObject().add(this);

	}

	public void onDestroyed() {

		this.destroyed = true;
		if (this.isDestroyed()) {
			GameLogic.getBulletInField().remove(this);
		}
	}

	@Override
	public boolean isCollideWith(Collidable balloon) {

		return Math.hypot(getPos().getX() - ((Balloon) balloon).getPos().getX(),
				getPos().getY() - ((Balloon) balloon).getPos().getY()) <= radius + ((Balloon) balloon).getRadius();
	}

	@Override
	public void update() {

		getPos().move(Math.cos(Math.toRadians(angle)) * bulletSpeed, Math.sin(Math.toRadians(angle)) * bulletSpeed);

	}

	public void onCollision(Balloon balloon) {

		balloon.hitByBullet(this);
		destroyed = true;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(ImageManager.getImage(image));
		Rotate rotate = new Rotate(angle, 10, 10);

		rotate.setPivotX(30);
		rotate.setPivotY(30);
		imageView.getTransforms().add(rotate);

		WritableImage rotatedImage = imageView.snapshot(null, null);

		gc.drawImage(UtilityGUI.makeTransparent(rotatedImage), getPos().getX() - radius, getPos().getY() - radius);

	}

	public int getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = Math.max(1, bulletSpeed);
	}

	public int getRadius() {
		return radius;
	}

	public boolean isGetHit() {
		return getHit;
	}

	public void setGetHit(boolean getHit) {
		this.getHit = getHit;
	}
	
	

}
