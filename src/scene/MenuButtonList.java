package scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuButtonList extends VBox {

	private GameButton playButton;
	private GameButton settingButton;
	private GameButton helpButton;
	private GameButton creditButton;
	private GameButton quitButton;

	public MenuButtonList() {

		setPrefWidth(700);
		setPrefHeight(100);
		setAlignment(Pos.CENTER);
		setSpacing(20);
		setTranslateY(150);

		playButton = new GameButton("Play", 400, 40);
		helpButton = new GameButton("Help", 400, 40);
		settingButton = new GameButton("Setting", 400, 40);
		creditButton = new GameButton("Credit", 400, 40);
		quitButton = new GameButton("Exit", 400 ,40);

		getChildren().addAll(playButton, helpButton, settingButton, creditButton, quitButton);

	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button getSettingButton() {
		return settingButton;
	}

	public Button getHelpButton() {
		return helpButton;
	}

	public Button getCreditButton() {
		return creditButton;
	}

	public Button getQuitButton() {
		return quitButton;
	}
}