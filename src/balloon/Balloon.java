package balloon;

import resource.ImageManager;
import resource.ImageManager.Images;
import scene.GameScene;
import sharedObject.Collidable;
import sharedObject.Entity;
import utility.UtilityGUI;
import bullet.Bullet;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import java.text.DecimalFormat;

public abstract class Balloon extends Entity implements Collidable {

	private double speed, travelDistance;
	private int damage, radius;

	public Balloon(Images image, double x, double y, double speed, int damage) {
		super(image, x, y);

		this.setSpeed(speed);
		this.setDamage(damage);
		this.setTravelDistance(0);
		this.z = 10;
		radius = 60;

		GameLogic.getBalloonInField().add(this);
		GameLogic.getGameFlowObject().add(this);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getTravelDistance() {
		return travelDistance;
	}

	public void setTravelDistance(double travelDistance) {
		this.travelDistance = Math.max(0, travelDistance);
	}

	@Override
	public void update() {
		
		DecimalFormat df = new DecimalFormat("#.00");
		double x = Double.parseDouble(df.format(getPos().getX()));
		double y = Double.parseDouble(df.format(getPos().getY()));
		
		if (GameScene.isDefaultMap()) {
			
			if(x > -10 && x < speed * Math.floor(225 / speed) && y == 70)
				getPos().move(speed, 0);
			if(x == speed * Math.floor(225 / speed) && y == 70)
				getPos().move(225 - (speed * Math.floor(225 / speed)), 0);
			
			if(x == 225 && y >= 70 && y < 70 + speed * Math.floor(305 / speed))
				getPos().move(0, speed); 
			if(x == 225 && y == 70 + speed * Math.floor(305 / speed))
				getPos().move(0, 305 - speed * Math.floor(305 / speed));
			
			if(x >= 225 && x < 225 + speed * Math.floor(150 / speed) && y == 375)
				getPos().move(speed, 0); 
			if(x == 225 + speed * Math.floor(150 / speed) && y == 375)
				getPos().move(150 - (speed * Math.floor(150 / speed)), 0);
			
			if(x == 375 && y <= 375 && y > Double.parseDouble(df.format(375 - (speed * Math.floor(300 / speed)))))
				getPos().move(0, -speed); 
			if(x == 375 && y == Double.parseDouble(df.format(375 - (speed * Math.floor(300 / speed)))))
				getPos().move(0, 75 - Double.parseDouble(df.format(375 - (speed * Math.floor(300 / speed))))); 
				
			if(x >= 375 && x < 375 + speed * Math.floor(550 / speed) && y == 75)
				getPos().move(speed, 0); 
			if(x == 375 + speed * Math.floor(550 / speed) && y == 75)
				getPos().move(550 - (speed * Math.floor(550 / speed)), 0);
			
			if(x == 925 && y >= 75 && y < 75 + speed * Math.floor(150 / speed))
				getPos().move(0, speed); 
			if(x == 925 && y == 75 + speed * Math.floor(150 / speed))
				getPos().move(0, 150 - speed * Math.floor(150 / speed));
	
			if(x <= 925 && x > Double.parseDouble(df.format(925 - (speed * Math.floor(400 / speed)))) && y == 225)
				getPos().move(-speed, 0); 
			if(x == Double.parseDouble(df.format(925 - (speed * Math.floor(400 / speed)))) && y == 225)
				getPos().move(525 - Double.parseDouble(df.format(925 - (speed * Math.floor(400 / speed)))),0);
			
				
			if(x == 525 && y >= 225 && y < 225 + speed * Math.floor(150 / speed))
				getPos().move(0, speed); 
			if(x == 525 && y == 225 + speed * Math.floor(150 / speed))
				getPos().move(0, 150 - speed * Math.floor(150 / speed));
			
			if(x >= 525 && x < 525 + speed * Math.floor(200 / speed) && y == 375)
				getPos().move(speed, 0); 
			if(x == 525 + speed * Math.floor(200 / speed) && y == 375)
				getPos().move(200 - (speed * Math.floor(200 / speed)), 0);
			
			if(x == 725 && y <= 375 && y > Double.parseDouble(df.format(375 - (speed * Math.floor(50 / speed)))))
				getPos().move(0, -speed); 
			if(x == 725 && y == Double.parseDouble(df.format(375 - (speed * Math.floor(50 / speed)))))
				getPos().move(0, 325 - Double.parseDouble(df.format(375 - (speed * Math.floor(50 / speed))))); 
			
			if(x >= 725 && x < 725 + speed * Math.floor(150 / speed) && y == 325)
				getPos().move(speed, 0); 
			if(x == 725 + speed * Math.floor(150 / speed) && y == 325)
				getPos().move(150 - (speed * Math.floor(150 / speed)), 0);
			 

			if(x == 875 && y >= 325)
				getPos().move(0, speed);

			
		} else {
			
			if(x == 300 && y <= 508 && y > Double.parseDouble(df.format(508 - (speed * Math.floor(358 / speed)))))
				getPos().move(0, -speed); 
			if(x == 300 && y == Double.parseDouble(df.format(508 - (speed * Math.floor(358 / speed)))))
				getPos().move(0, 150 - Double.parseDouble(df.format(508 - (speed * Math.floor(358 / speed))))); 
			
			if(x >= 300 && x < 300 + speed * Math.floor(425 / speed) && y == 150)
				getPos().move(speed, 0); 
			if(x == 300 + speed * Math.floor(425 / speed) && y == 150)
				getPos().move(425 - (speed * Math.floor(425 / speed)), 0);
			
			if(x == 725 && y >= 150)
				getPos().move(0, speed);
			
		}
	}

	@Override
	public boolean isCollideWith(Collidable bullet) {

		return Math.hypot(getPos().getX() - ((Bullet) bullet).getPos().getX(),
				getPos().getY() - ((Bullet) bullet).getPos().getY()) <= radius + ((Bullet) bullet).getRadius();
	}

	public void hitByBullet(Bullet bullet) {

		if (!bullet.isGetHit()) {
			this.destroyed = true;
			bullet.setGetHit(true);
		}
		
		UtilityGUI.balloonPopped();;

	}

	@Override
	public void draw(GraphicsContext gc) {

		gc.drawImage(ImageManager.getImage(image), getPos().getX() - radius / 2, getPos().getY() - radius / 2);

	}

	public int getRadius() {
		return radius;
	}

}