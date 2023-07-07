package scene;

import javafx.application.Platform;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import logic.AudioSetting;
import logic.GameLogic;
import logic.RoundManager;
import map.Field;
import resource.ImageManager;
import resource.ImageManager.Images;
import utility.Configuration;
import utility.Utility;

public class GameScene extends BorderPane {

	private static HealthBarPanel topBar;
	private static TowerSelectionPanel botBar;
	private static StackPane map;
	private static String currentTower;
	private static Field field;
	private static boolean onSelect, isDefaultMap, isOnGoing;

	public GameScene(boolean isDefaultMap) {

		AudioSetting.setState(1);
		AudioSetting.nextSong();
		System.out.println("Initialized game");
		System.out.println("Game music plays");

		topBar = new HealthBarPanel();
		botBar = new TowerSelectionPanel();

		onSelect = false;
		isOnGoing = true;
		GameScene.isDefaultMap = isDefaultMap;

		setPrefSize(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);
		setStyle("-fx-background-color: #6CA5C8");

		field = new Field(isDefaultMap);
		map = new StackPane();

		setMapBackground(map, isDefaultMap);

		currentTower = "None";

		map.setMaxSize(1000, 508);

		setTop(topBar);
		setCenter(map);
		setBottom(botBar);

		new GameLogic();

	}
	
	public static void update() {
		// TODO Auto-generated method stub
		getBottomBar().getMoney().setText("$" + GameLogic.getMoney());
		getTopBar().getHealth().setText("HP : " + GameLogic.getHitPoint());
		HealthBarPanel.getLifeProgress().setProgress(GameLogic.getHitPoint() / 150.0);
		getBottomBar().getTimer().setText(GameLogic.getCurrentTime());
		getTopBar().getRound().setText("Round " + RoundManager.getRound());
		TowerSelectionPanel.update();

		if (GameLogic.getHitPoint() <= 0) {

			isOnGoing = false;
			System.out.println("You lost !");
			StackPane loseScene = new StackPane();
			loseScene.setBackground(new Background(
					new BackgroundImage(ImageManager.getImage(Images.LOSE_SCENE), BackgroundRepeat.NO_REPEAT,
							BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(
									Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT, false, false, false, false))));
			GameButton resetButton = new GameButton("Quit", 200, 40);
			resetButton.setTranslateY(300);
			MainMenuScene.getRoot().getChildren().addAll(loseScene, resetButton);
			Utility.resetGame();
			
			resetButton.setOnAction((e) -> {
				
				Platform.exit();
				System.out.println("You quit the game");
				
			});
		}

		if (RoundManager.getRound() == 12 && RoundManager.isRoundEnd() && isOnGoing) {
			
			System.out.println("You won!");
			StackPane winScene = new StackPane();
			winScene.setBackground(new Background(
					new BackgroundImage(ImageManager.getImage(Images.WIN_SCENE), BackgroundRepeat.NO_REPEAT,
							BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(
									Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT, false, false, false, false))));
			GameButton resetButton = new GameButton("Quit", 200, 40);
			resetButton.setTranslateY(300);
			MainMenuScene.getRoot().getChildren().addAll(winScene, resetButton);
			Utility.resetGame();
			
			resetButton.setOnAction((e) -> {
				
				Platform.exit();
				System.out.println("You quit the game");
				
			});

		}
	}
	
	private static void setMapBackground(StackPane map, boolean isDefaultMap) {

		if (isDefaultMap) {
			map.setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.GRASS_MAP),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(1000, 508, false, false, false, false))));
		} else {
			map.setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.SEA_MAP),
					BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
					new BackgroundSize(1000, 508, false, false, false, false))));
		}
	}

	public static HealthBarPanel getTopBar() {
		return topBar;
	}

	public static TowerSelectionPanel getBottomBar() {
		return botBar;
	}

	public static String getCurrentTower() {
		return currentTower;
	}

	public static void setCurrentTower(String current) {

		currentTower = current;

	}

	public static StackPane getMap() {
		return map;
	}

	public static Field getField() {
		return field;
	}

	public static boolean isOnSelect() {
		return onSelect;
	}

	public static void setOnSelect(boolean onSelect) {
		GameScene.onSelect = onSelect;
	}

	public static boolean isDefaultMap() {
		return isDefaultMap;
	}

	public static boolean isOnGoing() {
		return isOnGoing;
	}

	public static void setOnGoing(boolean isOnGoing) {
		GameScene.isOnGoing = isOnGoing;
	}

}