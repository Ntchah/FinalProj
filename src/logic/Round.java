package logic;

import java.time.Duration;

import balloon.BlackBalloon;
import balloon.BlueBalloon;
import balloon.CeramicBalloon;
import balloon.GreenBalloon;
import balloon.LeadBalloon;
import balloon.PinkBalloon;
import balloon.PurpleBalloon;
import balloon.RainbowBalloon;
import balloon.RedBalloon;
import balloon.WhiteBalloon;
import balloon.YellowBalloon;
import balloon.ZebraBalloon;
import scene.GameScene;

public class Round {

	private static long startTime;
	private static long elapsedTime;
	private static long remainingTime;
	private static Duration baseSpawnSpeed;
	private static double startX, startY;
	private static int roundNumber;
	private static boolean isSpawning;
	private static int balloonNumber;
	
	public Round() {
		
		if (GameScene.isDefaultMap()) {
			startX = 0;
			startY = 70;
		} else {
			startX = 300;
			startY = 508;
		}
		startTime = System.nanoTime();
		roundNumber = RoundManager.getRound();
		isSpawning = true;
		
		balloonNumber = RoundManager.getRound() * 10;
		
	}
	
	public static void update() {
		
		switch (roundNumber) {
		case 1 :
		
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				startTime = System.nanoTime();
				balloonNumber--;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
		
		
		case 2 :
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				startTime = System.nanoTime();
				balloonNumber -= 2;

			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 3 :
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				startTime = System.nanoTime();
				balloonNumber -= 3;

			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 4 :
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 4;

			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 5:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 5;

			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 6:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 6;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 7:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 7;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 8:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				new PurpleBalloon(startX, startY);
				
				
				startTime = System.nanoTime();
				balloonNumber -= 8;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 9:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				new PurpleBalloon(startX, startY);
				new LeadBalloon(startX, startY);
				
				
				startTime = System.nanoTime();
				balloonNumber -= 9;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 10:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				new PurpleBalloon(startX, startY);
				new LeadBalloon(startX, startY);
				new ZebraBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 10;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 11:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				new PurpleBalloon(startX, startY);
				new LeadBalloon(startX, startY);
				new ZebraBalloon(startX, startY);
				new RainbowBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 11;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
		case 12:
			
			baseSpawnSpeed = Duration.ofMillis(600);
			elapsedTime = System.nanoTime() - startTime;
			remainingTime = baseSpawnSpeed.toNanos() - elapsedTime;
			
			if (remainingTime <= 0 && balloonNumber > 0) {
				new RedBalloon(startX, startY);
				new BlueBalloon(startX, startY);
				new GreenBalloon(startX, startY);
				new YellowBalloon(startX, startY);
				new PinkBalloon(startX, startY);
				new BlackBalloon(startX, startY);
				new WhiteBalloon(startX, startY);
				new PurpleBalloon(startX, startY);
				new LeadBalloon(startX, startY);
				new ZebraBalloon(startX, startY);
				new RainbowBalloon(startX, startY);
				new CeramicBalloon(startX, startY);
				
				startTime = System.nanoTime();
				balloonNumber -= 12;
			}
			
			if (balloonNumber == 0) {
				isSpawning = false;
			}
			
			break;
			
			
			
			
		
		}
	}

	public static boolean isSpawning() {
		return isSpawning;
	}
	
}
