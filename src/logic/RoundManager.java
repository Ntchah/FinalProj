package logic;

import java.time.Duration;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import resource.FontManager;
import resource.FontManager.Fonts;
import scene.GameScene;


public class RoundManager {

	private static int round = 0;
	private static final Duration TIME_BETWEEN_ROUND = Duration.ofMillis(5000);
	private static final Duration TIME_STRING = Duration.ofMillis(2500);
	private static long timeStampRound, timeStampText;
	private static boolean isRoundEnd;
	private static Label roundText;
	private static boolean textOn;
	
	public RoundManager() {
		
		round = 0;
		timeStampRound = System.nanoTime();
		timeStampText = System.nanoTime();
		startNewRound();
		
		
		roundText = new Label("ROUND " + round);
		roundText.setFont(FontManager.getFont(Fonts.ROUND_SHOWING));
		roundText.setTextFill(Color.web("#FF8000"));
		roundText.setStyle("-fx-effect: dropshadow( one-pass-box , black , 20 , 0.0 , 0 , 1 );");
		
		roundText.setVisible(false);
		textOn = false;
		
		GameScene.getMap().getChildren().add(roundText);
		
	}
	private static void startNewRound() {
		
		if (isRoundEnd) {
			
			System.out.println("Round " + (round + 1) + " has started");
			isRoundEnd = false;
			round++;
			new Round();
			
		}

	}
	public static int getRound() {
		return round;
	}

	public static void update() {
		// TODO Auto-generated method stub
		
		if (GameLogic.getBalloonInField().size() == 0 && !isRoundEnd && !Round.isSpawning()) {
			isRoundEnd = true;
			timeStampRound = System.nanoTime();
			
			if (round != 0) {
				System.out.println("Round " + round + " has ended");
			}

		} 
		
		if (Round.isSpawning()) {
			Round.update();
		}
		
		if (isRoundEnd) {
			
			GameLogic.getGameFlowObject().clear();
			long elapsedTime = System.nanoTime() - timeStampRound;
			long remainingTime = TIME_BETWEEN_ROUND.toNanos() - elapsedTime;
			
			if (remainingTime <= 0) {
				timeStampRound = System.nanoTime();
				startNewRound();
				roundText.setText("ROUND " + round);
				roundText.setVisible(true);
				timeStampText = System.nanoTime();
				textOn = true;
			}

		}
		
		if (textOn) {
			long elapsedTimeText = System.nanoTime() - timeStampText;
			long remainingTimeText = TIME_STRING.toNanos() - elapsedTimeText;
			if (remainingTimeText <= 0) {
				roundText.setVisible(false);
				textOn = false;
			}
		}
	}
	
	public static void resetRound() {
		
		round = 0;
		isRoundEnd = false;
		
	}
	public static boolean isRoundEnd() {
		return isRoundEnd;
	}
	
	
}
