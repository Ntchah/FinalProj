package scene;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import resource.FontManager;
import resource.FontManager.Fonts;
import utility.Configuration;

public class ExitScene extends StackPane {

	private static final double WIDTH = Configuration.GAME_WIDTH * 0.5;
	private static final double HEIGHT = Configuration.GAME_HEIGHT * 0.3;
	private GameButton noButton, yesButton;
	private VBox panel;
	private Label header;

	public ExitScene() {

		StackPane bg = new StackPane();
		bg.setPrefSize(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);
		bg.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		bg.setOpacity(0.5);

		setScene();
		setUpQuitButton();

		getChildren().addAll(bg, panel);

	}

	private void setScene() {

		panel = new VBox();
		panel.setMaxSize(WIDTH, HEIGHT);
		panel.setAlignment(Pos.TOP_CENTER);
		panel.setStyle(
				"-fx-background-radius: 18; -fx-background-color: #6CA5C8; -fx-border-color: #1C346F; -fx-border-radius: 18; -fx-border-width: 2;");

		setTopper();
		setBottom();

	}

	private void setTopper() {

		HBox info = new HBox();
		info.setAlignment(Pos.CENTER);
		info.setStyle("-fx-background-radius: 15 15 0 0; -fx-background-color: #1C346F;");
		info.setSpacing(30);
		info.setPrefSize(WIDTH, HEIGHT * 0.55);
		header = new Label("Are You Sure You Want To Quit ?");
		header.setFont(FontManager.getFont(Fonts.TEXT));
		header.setTextFill(Color.web("#F1EAFC"));

		info.getChildren().add(header);

		panel.getChildren().add(info);

	}

	private void setBottom() {

		HBox confirmBox = new HBox();
		confirmBox.setAlignment(Pos.CENTER);
		confirmBox.setSpacing(WIDTH / 3);
		confirmBox.setTranslateY(20);

		noButton = new GameButton("No", 100, 40);
		yesButton = new GameButton("Yes", 100, 40);

		confirmBox.getChildren().addAll(noButton, yesButton);

		panel.getChildren().add(confirmBox);

	}

	private void setUpQuitButton() {

		yesButton.setOnAction((e) -> {

			System.out.println("You quit the game");
			Platform.exit();

		});

		MainMenuScene.getScene().setOnKeyPressed((event) -> {

			if (event.getCode() == KeyCode.ENTER) {
				System.out.println("You quit the game");
				Platform.exit();
			}

		});

	}

}