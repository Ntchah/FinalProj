package scene;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import resource.FontManager;
import resource.FontManager.Fonts;
import resource.ImageManager;
import resource.ImageManager.Images;
import utility.Configuration;
import utility.UtilityGUI;

public class MapSelectScene extends StackPane {

	private static final double WIDTH = Configuration.GAME_WIDTH * 0.85;
	private static final double HEIGHT = Configuration.GAME_HEIGHT * 0.75;

	private MenuPanel panel;
	private GameButton playButton, previousButton, nextButton;
	private Label mapName;
	private ImageView currentShowing;
	private boolean isDefault;

	public MapSelectScene() {

		isDefault = true;
		
		setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.BACKGROUND2), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT, false, false, false, false))));
		panel = new MenuPanel(WIDTH, HEIGHT);

		setTopper();
		setCenter();
		setBottom();

		setUpButton();
		getChildren().add(panel);

	}

	private void setTopper() {

		Label header = new Label("Choose Map");
		header.setFont(FontManager.getFont(Fonts.TITLE_MENU_PANEL));
		header.setTextFill(Color.web("#F1EAFC"));
		
		panel.getTopPart().setSpacing(235);

		panel.getTopPart().getChildren().add(header);

	}

	private void setCenter() {
		
		panel.getMiddlePart().setSpacing(20);

		mapName = new Label("Grass Map");
		mapName.setFont(FontManager.getFont(Fonts.TEXT));
		mapName.setTextFill(Color.web("#8D0F0F"));

		HBox mapSelector = new HBox();
		mapSelector.setAlignment(Pos.CENTER);
		mapSelector.setSpacing(5);

		previousButton = new GameButton("<", 40, 20);

		StackPane imageWrapper = new StackPane();
		imageWrapper.setMaxSize((int) WIDTH / 2, (int) HEIGHT / 2);
        
		currentShowing = ImageManager.getImageView(Images.GRASS_MAP, (int) WIDTH / 2, (int) HEIGHT / 2);

		Rectangle border = new Rectangle(currentShowing.getFitWidth(), currentShowing.getFitHeight());
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(2);
        border.setFill(Color.TRANSPARENT);
        border.setArcWidth(10);
        border.setArcHeight(10);
        
        imageWrapper.getChildren().addAll(currentShowing, border);


		nextButton = new GameButton(">", 40, 20);
	
		mapSelector.getChildren().addAll(previousButton, imageWrapper, nextButton);

		panel.getMiddlePart().setTranslateY(20);
		panel.getMiddlePart().getChildren().addAll(mapName, mapSelector);

	}

	private void setBottom() {

		playButton = new GameButton("Play", 200, 40);
		playButton.setPrefSize(200, 40);
	
		panel.getBottomPart().getChildren().add(playButton);

	}

	private void setUpButton() {
		
		UtilityGUI.buttonHovered(playButton);
		UtilityGUI.buttonHovered(nextButton);
		UtilityGUI.buttonHovered(previousButton);

		nextButton.setOnAction((e) -> {

			if (isDefault) {
				isDefault = !isDefault;
				mapName.setText("Sea Map");
				currentShowing.setImage(ImageManager.getImage(Images.SEA_MAP));
			} else {
				isDefault = !isDefault;
				mapName.setText("Grass Map");
				currentShowing.setImage(ImageManager.getImage(Images.GRASS_MAP));
			}

		});

		previousButton.setOnAction((e) -> {

			if (isDefault) {
				isDefault = !isDefault;
				mapName.setText("Sea Map");
				currentShowing.setImage(ImageManager.getImage(Images.SEA_MAP));
			} else {
				isDefault = !isDefault;
				mapName.setText("Grass Map");
				currentShowing.setImage(ImageManager.getImage(Images.GRASS_MAP));
			}

		});
		
		playButton.setOnAction((e) -> {
			
			MainMenuScene.getRoot().getChildren().remove(this);
			MainMenuScene.getRoot().getChildren().add(new GameScene(isDefault));
			System.out.println("Game has been started : " + mapName.getText() + " has been selected");
			
		});

	}

}
