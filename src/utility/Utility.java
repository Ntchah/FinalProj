package utility;

import logic.GameLogic;
import logic.RoundManager;
import sharedObject.Entity;

public class Utility {

	public static double getObjectDistance(Entity obj1, Entity obj2) {
		return Math.sqrt(Math.pow(obj1.getPos().getX() - obj2.getPos().getX(), 2)
				+ Math.pow(obj1.getPos().getY() - obj2.getPos().getY(), 2));
	}

	public static double turningDegree(Entity obj1, Entity obj2) {
		
		double deltaX = obj2.getPos().getX() - obj1.getPos().getX();
		double deltaY = obj2.getPos().getY() - obj1.getPos().getY();

		return Math.toDegrees(Math.atan2(deltaY, deltaX));
		
	}
	
	public static void resetGame() {
		
		GameLogic.resetGame();
		RoundManager.resetRound();
		
	}

}
