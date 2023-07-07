	package scene;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.RoundManager;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import resource.FontManager;
import resource.FontManager.Fonts;
import resource.ImageManager;
import resource.ImageManager.Images;
import javafx.scene.layout.StackPane;
import utility.Configuration;

public class HealthBarPanel extends BorderPane {

	private static final double HEIGHT = Configuration.GAME_HEIGHT * 0.06;
	private static ProgressBar lifeProgress;
	private Label health, round;

	public HealthBarPanel() {

		setPrefHeight(HEIGHT);
		setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.TOPPER),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(Configuration.GAME_WIDTH, HEIGHT, false, false, false, false))));

		round = new Label("Round " + RoundManager.getRound());
		round.setFont(FontManager.getFont(Fonts.TEXT));
		round.setTextFill(Color.WHITE);
		round.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");
		round.setTranslateX(-200);

		StackPane hpProgress = new StackPane();

		setHpBar();

		health = new Label("HP : " + GameLogic.getHitPoint());
		health.setFont(FontManager.getFont(Fonts.TEXT));
		health.setTextFill(Color.WHITE);
		health.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");
		health.setTranslateX(15);

		hpProgress.getChildren().addAll(lifeProgress, health);

		setCenter(round);
		setLeft(hpProgress);

	}

	private static void setHpBar() {

		lifeProgress = new ProgressBar();
		lifeProgress
				.setStyle("-fx-accent: #00FF00; -fx-control-inner-background: #660000; -fx-border-color: transparent;");
		lifeProgress.setProgress(GameLogic.getHitPoint() / 150.0);
		lifeProgress.setPrefSize(Configuration.GAME_WIDTH / 2 - 100, HEIGHT);
	}

	public static ProgressBar getLifeProgress() {
		return lifeProgress;
	}

	public Label getHealth() {
		return health;
	}

	public Label getRound() {
		return round;
	}
	
}
