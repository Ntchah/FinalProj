package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameLogic;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import resource.FontManager;
import resource.FontManager.Fonts;
import resource.ImageManager;
import resource.ImageManager.Images;
import utility.Configuration;

public class TowerSelectionPanel extends HBox {

	private static final double HEIGHT = Configuration.GAME_WIDTH * 0.15;
	private static TowerButton dartShooter, ninja, sniper, scubaDiver;
	private VBox gameStatus;
	private Button quit;
	private Label money, timer;
	
	public TowerSelectionPanel() {
		
		setSpacing(25);
		setPrefHeight(HEIGHT);
		setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.BACKGROUND3), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(Configuration.GAME_WIDTH, HEIGHT, false, false, false, false))));
		
		setPadding(new Insets(0, 30, 0, 30));
		
		dartShooter = new TowerButton(ImageManager.getImageView(Images.DARTSHOOTER, 45, 50), "Dartshooter" , "300");
		ninja = new TowerButton(ImageManager.getImageView(Images.NINJA, 45, 50), "Ninja" , "400");
		sniper = new TowerButton(ImageManager.getImageView(Images.SNIPER, 40, 50), "Sniper" , "350");
		scubaDiver = new TowerButton(ImageManager.getImageView(Images.SCUBADIVER, 40, 50), "Scubadiver" , "400");
		
		gameStatus = new VBox();
		gameStatus.setPrefSize(250, HEIGHT);
		gameStatus.setAlignment(Pos.TOP_CENTER);
		gameStatus.setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.BACKGROUND4), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(250, HEIGHT, false, false, false, false))));
		
		gameStatus.setAlignment(Pos.CENTER);
		
		quit = new Button("Quit");
		quit.setTextFill(Color.BLACK);
		quit.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");	
		quit.setFont(FontManager.getFont(Fonts.SETTING));	
		quit.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
				
		money = new Label(Integer.toString(GameLogic.getMoney()));
		money.setFont(FontManager.getFont(Fonts.TIME_TEXT));
		
		timer = new Label("00:00");
		timer.setFont(FontManager.getFont(Fonts.TIME_TEXT));
		
		gameStatus.getChildren().addAll(timer, money, quit);

		
		getChildren().addAll(dartShooter, ninja, sniper, scubaDiver, gameStatus);
		
		setUpButton();

		
	}
	
	public static void update() {
		
		dartShooter.update();
		ninja.update();
		sniper.update();
		scubaDiver.update();
		
	}
	
	private void setUpButton() {
	
		
		quit.setOnAction((e) -> {
			
			MainMenuScene.getRoot().getChildren().add(new ExitScene());
			
		});
		
		quit.setOnMouseEntered((e) -> {
			
			quit.setTextFill(Color.GREY);
			quit.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");			
		});
		
		quit.setOnMouseExited((e) -> {
			
			quit.setTextFill(Color.BLACK);
			quit.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");			
			
		});
	}

	public Label getMoney() {
		return money;
	}

	public Label getTimer() {
		return timer;
	}
	
}
