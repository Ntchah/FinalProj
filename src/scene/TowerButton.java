package scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameLogic;
import map.Field;
import resource.FontManager;
import resource.FontManager.Fonts;
import tower.DartShooter;
import tower.Ninja;
import tower.ScubaDiver;
import tower.Sniper;

public class TowerButton extends VBox {

	private Button tower;
	private Label name, priceLabel;
	private int price;

	public TowerButton(ImageView image, String name, String price) {

		setAlignment(Pos.CENTER);

		tower = new Button();
		tower.setPrefSize(60, 60);
		tower.setGraphic(image);

		this.name = new Label(name);
		this.priceLabel = new Label("$" + price);

		this.price = Integer.parseInt(price);

		setUp();

		getChildren().addAll(tower, this.name, this.priceLabel);

	}

	private void setUp() {

		tower.setOnAction((event) -> {

			if (!GameScene.isOnSelect() && GameLogic.getMoney() >= price) {
				System.out.println("Current tower is: " + name.getText());
				GameScene.setCurrentTower(name.getText());
				GameScene.getMap().getChildren().add(GameScene.getField());
				GameScene.setOnSelect(true);

				MainMenuScene.getScene().setOnMouseClicked((e) -> {
					
					if (e.getY() <= 550) {
						int col = (int) (e.getX() / 50);
						int row = (int) ((e.getY() - 50) / 50);
						
						int[][] mapSquare;
						if (GameScene.isDefaultMap()) {
							mapSquare = Field.GRASS_TERRAIN;
						} else {
							mapSquare = Field.SEA_TERRAIN;
						}
											
						if (mapSquare[row][col] != 0) {
							GameScene.getField();
							if (Field.isSuccess()) {
								
								switch (GameScene.getCurrentTower()) {

								case "Dartshooter":
									if (row == 0) {
										new DartShooter(col * 50, row * 50);
									} else if (mapSquare[row - 1][col] ==0) {
										new DartShooter(col * 50, row * 50);
									} else {
										new DartShooter(col * 50, row * 50 + 50);
									}
									GameLogic.setMoney(GameLogic.getMoney() - DartShooter.BASE_PRICE);

									break;

								case "Ninja":
									if (row == 0) {
										new Ninja(col * 50, row * 50);
									} else if (mapSquare[row - 1][col] ==0) {
										new Ninja(col * 50, row * 50);
									} else {
										new Ninja(col * 50, row * 50 + 50);
									}
									GameLogic.setMoney(GameLogic.getMoney() - Ninja.BASE_PRICE);

									break;

								case "Sniper":
									if (row == 0) {
										new Sniper(col * 50, row * 50);
									} else if (mapSquare[row - 1][col] ==0) {
										new Sniper(col * 50, row * 50);
									} else {
										new Sniper(col * 50, row * 50 + 50);
									}
									GameLogic.setMoney(GameLogic.getMoney() - Sniper.BASE_PRICE);
									break;

								case "Scubadiver":
									
									if (mapSquare[row][col] == 2) {
										if (row == 0) {
											new ScubaDiver(col * 50, row * 50);
										} else if (mapSquare[row - 1][col] ==0) {
											new ScubaDiver(col * 50, row * 50);
										} else {
											new ScubaDiver(col * 50, row * 50 + 50);
										}
										GameLogic.setMoney(GameLogic.getMoney() - ScubaDiver.BASE_PRICE);
									}
									
									break;

								case "None":
									e.consume();
									break;

								}

								GameScene.setCurrentTower("None");
								event.consume();
							}
						}
					} else {
						
						event.consume();
					}

				});
			} else if (GameLogic.getMoney() < price) {
				System.out.println("Not enough money");
				event.consume();
			}
		});

	}

	public void update() {
		if (GameLogic.getMoney() < price) {

			this.priceLabel.setFont(FontManager.getFont(Fonts.BUYING_TEXT));
			this.priceLabel.setTextFill(Color.RED);
			this.priceLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");

			this.name.setFont(FontManager.getFont(Fonts.BUYING_TEXT));
			this.name.setTextFill(Color.RED);
			this.name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");

			tower.setStyle("-fx-border-color: black; " + "-fx-border-width: 2px; " + "-fx-border-radius: 5px;"
					+ "-fx-background-radius: 5px; -fx-background-color: red;");
			setUp();

		} else {

			this.name.setFont(FontManager.getFont(Fonts.BUYING_TEXT));
			this.name.setTextFill(Color.WHITE);
			this.name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");

			this.priceLabel.setFont(FontManager.getFont(Fonts.BUYING_TEXT));
			this.priceLabel.setTextFill(Color.WHITE);
			this.priceLabel.setStyle("-fx-effect: dropshadow( one-pass-box , black , 3 , 0.0 , 0 , 1 );");

			tower.setStyle("-fx-border-color: black; " + "-fx-border-width: 2px; " + "-fx-border-radius: 5px;"
					+ "-fx-background-radius: 5px;");
		}
	}

	public Label getName() {
		return name;
	}

	public Label getPrice() {
		return priceLabel;
	}

}
