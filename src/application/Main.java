package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import logic.AudioSetting;
import resource.ImageManager;
import resource.ImageManager.Images;
import scene.MainMenuScene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		new MainMenuScene(primaryStage);
		System.out.println("Application started");
		primaryStage.setTitle("Balloon Battles");
		primaryStage.getIcons().add(ImageManager.getImage(Images.LOGO));
		AudioSetting.playMedia();
		primaryStage.show();

		primaryStage.setOnCloseRequest((event) -> {

			event.consume();

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you sure you want to close?");
			alert.setContentText("Any unsaved changes will be lost.");
			alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> {
				System.out.println("Application closed");
				primaryStage.close();
			});

		});

	}

	public static void main(String[] args) {

		launch(args);

	}

}
