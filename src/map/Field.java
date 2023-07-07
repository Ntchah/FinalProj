package map;

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import resource.ImageManager;
import resource.ImageManager.Images;

public class Field extends GridPane {

	private static ArrayList<Square> squares = new ArrayList<>();
	private boolean isDefault;
	private static boolean isSuccess;

	public static final int[][] GRASS_TERRAIN = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 2, 2, 2, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 2, 2, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 2, 2, 2, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1 },
			{ 2, 2, 2, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1 },
			{ 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
			{ 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1 } };

	public static final int[][] SEA_TERRAIN = { { 0, 0, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0 },
			{ 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0 },
			{ 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 0 },
			{ 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2 } };

	public Field(boolean isDefault) {

		this.isDefault = isDefault;
		this.setPrefHeight(508);
		this.setPrefWidth(1000);
		
		if (isDefault) {
			setBackground(new Background(
					new BackgroundImage(ImageManager.getImage(Images.GRASS_MAP), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
							BackgroundPosition.CENTER, new BackgroundSize(1000, 508, false, false, false, false))));
		} else {
			setBackground(new Background(
					new BackgroundImage(ImageManager.getImage(Images.SEA_MAP), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
							BackgroundPosition.CENTER, new BackgroundSize(1000, 508, false, false, false, false))));
		}
		setOpacity(0.6);

		makeTiles();
		
	}

	public void makeTiles() {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				Square square = new Square();
				if (isDefault) {
					square.setTerrain(GRASS_TERRAIN[i][j]);
				} else {
					square.setTerrain(SEA_TERRAIN[i][j]);
				}
				square.setMinHeight(50);
				square.setMinWidth(50);
				this.add(square, j, i);
				squares.add(square);

			}
		}
	}	

	public static ArrayList<Square> getSquares() {
		return squares;
	}

	public static boolean isSuccess() {
		return isSuccess;
	}

	public static void setSuccess(boolean isSuccess) {
		Field.isSuccess = isSuccess;
	}
	
}
