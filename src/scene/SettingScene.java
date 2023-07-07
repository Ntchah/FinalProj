package scene;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import utility.Configuration;
import utility.UtilityGUI;
import logic.AudioSetting;
import resource.FontManager;
import resource.FontManager.Fonts;

public class SettingScene extends StackPane {

	private static final double WIDTH = Configuration.MENU_PANEL_WIDTH;
	private static final double HEIGHT = Configuration.MENU_PANEL_HEIGHT;

	private MenuPanel panel;
	private GameButton applyButton, resetButton;
	private ComboBox<String> changeSong;
	private Slider volumeSlider;

	public SettingScene() {

		StackPane bg = new StackPane();
		bg.setPrefSize(Configuration.GAME_WIDTH, Configuration.GAME_HEIGHT);
		bg.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		bg.setOpacity(0.5);

		setScene();
		getChildren().addAll(bg, panel);

	}

	private void setScene() {

		panel = new MenuPanel(WIDTH, HEIGHT);

		setTopper();
		setCenter();
		setBottom();
		setUpButton();

	}

	private void setTopper() {

		Label header = new Label("Setting");
		header.setFont(FontManager.getFont(Fonts.TITLE_MENU_PANEL));
		header.setTextFill(Color.web("#F1EAFC"));

		panel.getTopPart().getChildren().add(header);

	}

	private void setCenter() {

		panel.getMiddlePart().setSpacing(40);

		Label volumeController = new Label("volume Level");
		volumeController.setFont(FontManager.getFont(Fonts.TEXT));
		volumeController.setTextFill(Color.web("#8D0F0F"));

		volumeSlider = new Slider();
		volumeSlider.setMin(0);
		volumeSlider.setMax(100);
		volumeSlider.setMaxWidth(150);

		Label changeMusic = new Label("Music");
		changeMusic.setFont(FontManager.getFont(Fonts.TEXT));
		changeMusic.setTextFill(Color.web("#8D0F0F"));

		changeSong = new ComboBox<>();
		changeSong.setValue(AudioSetting.getSongnumber().get(AudioSetting.getMusic()));

		changeSong.getItems().addAll("Default", "Equal Exchange", "Space", "Usamaro", "Limitless", "Bounce",
				"Adventure", "Timekeeper", "Risk");

		changeSong.setPrefWidth(150);

		changeSong.setCellFactory(param -> new ListCell<>() {

			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					setText(item);
					setAlignment(Pos.CENTER);
				}
			}

		});

		panel.getMiddlePart().getChildren().addAll(volumeController, volumeSlider, changeMusic, changeSong);

	}

	private void setBottom() {

		applyButton = new GameButton("Apply", 200, 40);

		resetButton = new GameButton("Reset", 200, 40);

		panel.getBottomPart().getChildren().addAll(resetButton, applyButton);

	}

	private void setUpButton() {

		UtilityGUI.buttonHovered(resetButton);
		UtilityGUI.buttonHovered(applyButton);

		resetButton.setOnAction((e) -> {

			AudioSetting.setMusic(AudioSetting.getSongname().get("Default"));
			AudioSetting.resetMedia();
			AudioSetting.nextSong();
			changeSong.setValue("Default");
			volumeSlider.setValue(50);
			MainMenuScene.getRoot().getChildren().remove(this);

			System.out.println("Music them reset to default");

		});

		applyButton.setOnAction((e) -> {

			AudioSetting.setMusic(AudioSetting.getSongname().get(changeSong.getValue()));
			AudioSetting.nextSong();
			changeSong.setValue(changeSong.getValue());
			AudioSetting.getMediaPlayer().setVolume(volumeSlider.getValue() * 0.01);
			volumeSlider.setValue(volumeSlider.getValue());
			MainMenuScene.getRoot().getChildren().remove(this);

			System.out.println("Music theme changed : " + changeSong.getValue());

		});

		volumeSlider.valueProperty().addListener((e) -> {

			AudioSetting.getMediaPlayer().setVolume(volumeSlider.getValue() * 0.01);

		});

	}

	public Slider getVolumeSlider() {
		return volumeSlider;
	}
}
