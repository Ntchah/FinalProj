package map;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import resource.ImageManager;
import resource.ImageManager.Images;
import scene.GameScene;

public class Square extends StackPane {

	int x, y;
	int terrain;
	boolean isOccupied = false;
	private boolean isPlaceable;

	public Square() {

		Field.setSuccess(false);

		this.setOnMouseEntered(event -> {
			if (!this.isOccupied) {
				switch (this.terrain) {

				case 0:
					setBackgroundRed();
					isPlaceable = false;
					break;

				case 1:

					if (GameScene.getCurrentTower().equals("Scubadiver")) {
						setBackgroundRed();
						isPlaceable = false;
						
					} else {
						setBackgroundGreen();
						isPlaceable = true;

					}
					break;

				case 2:

					if (!GameScene.getCurrentTower().equals("Scubadiver")) {
						setBackgroundRed();
						isPlaceable = false;

					} else {
						setBackgroundGreen();
						isPlaceable = true;

					}
					break;

				}
			}
		});

		this.setOnMouseExited(event -> {
			if (!this.isOccupied) {
				setBackgroundTransparent();
			}
		});

		this.setOnMouseClicked(event -> {

			if (!this.isOccupied) {
				switch (this.terrain) {

				case 1:

					if (!GameScene.getCurrentTower().equals("Scubadiver")) {
						
						switch (GameScene.getCurrentTower()) {

						case "Dartshooter":
							setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.DARTSHOOTER),
									BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
									new BackgroundSize(45, 50, false, false, false, false))));
							isOccupied = true;
							Field.setSuccess(true);

							break;

						case "Ninja":
							setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.NINJA),
									BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
									new BackgroundSize(45, 50, false, false, false, false))));
							isOccupied = true;
							Field.setSuccess(true);

							break;

						case "Sniper":
							setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.SNIPER),
									BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
									new BackgroundSize(40, 50, false, false, false, false))));
							isOccupied = true;
							Field.setSuccess(true);

							break;

						}

						GameScene.getMap().getChildren().remove(GameScene.getField());
						GameScene.setOnSelect(false);

					}
					break;

				case 2:
					if (GameScene.getCurrentTower().equals("Scubadiver")) {
						this.setBackground(new Background(new BackgroundImage(ImageManager.getImage(Images.SCUBADIVER),
								BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
								new BackgroundSize(40, 50, false, false, false, false))));
						this.isOccupied = true;
						Field.setSuccess(true);

					}

					GameScene.getMap().getChildren().remove(GameScene.getField());
					GameScene.setOnSelect(false);

					break;
				}
			} else {

				System.out.println("This block is occupied");
				Field.setSuccess(false);

			}

		});

	}

	public void setBackgroundRed() {
		this.setBackground(
				new Background(new BackgroundFill(Color.rgb(255, 99, 71, 0.6), CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setBackgroundGreen() {
		this.setBackground(
				new Background(new BackgroundFill(Color.rgb(25, 255, 0, 0.6), CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setBackgroundTransparent() {
		this.setBackground(new Background(new BackgroundFill(null, null, null)));

	}

	public void setTerrain(int terrain) {
		this.terrain = terrain;
	}

	public boolean isPlacable() {
		return isPlaceable;
	}

}