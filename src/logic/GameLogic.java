package logic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import sharedObject.Collidable;
import sharedObject.Entity;
import sharedObject.RenderableHolder;
import tower.Tower;
import balloon.Balloon;
import bullet.Bullet;
import javafx.animation.AnimationTimer;
import scene.GameScene;

public class GameLogic {
	
	private static ArrayList<Tower> towerInField;
	private static ArrayList<Balloon> balloonInField;
	private static ArrayList<Bullet> bulletInField;
	private static ArrayList<Entity> gameObject;
	private static ArrayList<Collidable> collidableObjects;
	private static int hitPoint = 150;
	private static int money = 500;
	private static long startTopUpTime, startTime;
	private static final Duration TOP_UP_SPEED = Duration.ofMillis(7000);
	private static String currentTime = "00:00";
	private static GameScreen gameScreen;
	private static AnimationTimer animation;

	
	public GameLogic() {
		
		towerInField = new ArrayList<>();
		balloonInField = new ArrayList<>();
		bulletInField = new ArrayList<>();
		gameObject = new ArrayList<>();
		collidableObjects = new ArrayList<>();
		gameScreen = new GameScreen(1000, 508);
		GameScene.getMap().getChildren().add(gameScreen);
		
		new RoundManager();
		
		gameScreen.requestFocus();
		startTopUpTime = System.nanoTime();
		startTime = System.nanoTime();
		
		animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				logicUpdate(now);
				RenderableHolder.getInstance().update();
				GameScene.update();
	            RoundManager.update();
			}
		};
		
		animation.start();
			
	}
	
	public static void addNewObject(Entity entity) {
		
		gameObject.add(entity);
		RenderableHolder.getInstance().add(entity);
		
	}
	
	public static void logicUpdate(long now) {

		long elapsedTime = System.nanoTime() - startTopUpTime;
		long remainingTopUpTime = TOP_UP_SPEED.toNanos() - elapsedTime;
		
		if (remainingTopUpTime <= 0) {
			startTopUpTime = System.nanoTime();
			money += 200;
		}
		
		long elapsedNanos = now - startTime;
		long elapsedSeconds = elapsedNanos / 1_000_000_000;
        long minutes = (elapsedSeconds % 3600) / 60;
        long seconds = elapsedSeconds % 60;

        currentTime = String.format("%02d:%02d", minutes, seconds);
		
		Collections.sort(balloonInField, Comparator.comparingDouble(Balloon::getTravelDistance).reversed());
		
		for (Bullet e : bulletInField) {
			for (Balloon balloon : balloonInField) {
				if (!balloon.isDestroyed() && balloon.isCollideWith(e)) {
					e.onCollision(balloon);
				}
			}

		}
		
		for (Collidable e : collidableObjects) {
			
			if (((Entity) e).destroyed) {
				 if (e instanceof Bullet) {
					bulletInField.remove(e);
				} else if (e instanceof Balloon) {
					balloonInField.remove(e);
				}
			}
		}
			
		for (Balloon b : balloonInField) {
			b.update();
		}
		
		for (Tower t : towerInField) {
			t.update();
		}
		
		for (Bullet b : bulletInField) {
			b.update();
		}
		
		for (Collidable object : collidableObjects) {
			
			if (object instanceof Balloon) {
				
				Balloon b = (Balloon) object;
				if (GameScene.isDefaultMap()) {
					if (b.getPos().getY() >= 508)
						if (!b.destroyed) {
							b.destroyed = true;
							balloonInField.remove(b);
							GameLogic.setHitPoint(GameLogic.getHitPoint() - b.getDamage());						
							
						}
					
				} else {
					
					if (b.getPos().getX() == 725 && b.getPos().getY() >= 508)
						if (!b.destroyed) {
							b.destroyed = true;
							balloonInField.remove(b);
							GameLogic.setHitPoint(GameLogic.getHitPoint() - b.getDamage());					
								
							}
						}
			}
			

			}
	}	
	
	
	public static void resetGame() {
		
		hitPoint = 150;
		money = 500;
		balloonInField.clear();
		bulletInField.clear();
		gameObject.clear();
		RenderableHolder.getInstance().getEntities().clear();
		gameScreen.getGc().clearRect(0, 0, 1000, 700);
		animation.stop();
		
	}

	public static ArrayList<Entity> getGameobject() {
		return gameObject;
	}

	public static ArrayList<Balloon> getBalloonInField() {
		return balloonInField;
	}

	public static ArrayList<Bullet> getBulletInField() {
		return bulletInField;
	}

	public static int getHitPoint() {
		return hitPoint;
	}

	public static void setHitPoint(int hitPoint) {
		GameLogic.hitPoint = Math.max(0, hitPoint);
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		GameLogic.money = Math.max(money, 0);
	}

	public static String getCurrentTime() {
		return currentTime;
	}

	public static GameScreen getGameScreen() {
		return gameScreen;
	}

	public static ArrayList<Collidable> getGameFlowObject() {
		return collidableObjects;
	}

	public static ArrayList<Tower> getTowerInField() {
		return towerInField;
	}
	
}
