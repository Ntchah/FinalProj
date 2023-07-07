package utility;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import resource.AudioManager;
import resource.AudioManager.Audios;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;

public class UtilityGUI {

	public static void playButtonClicked() {

		AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();
		
	}

	public static void balloonPopped() {

		AudioManager.getSoundTrack(Audios.BALLOON_POPPED).play();
		
	}

	public static void buttonHovered(Button button) {

		button.setOnMouseEntered((e) -> {

			button.setStyle(
					"-fx-background-radius: 10; -fx-background-color: #5D2C36; -fx-border-radius: 10; -fx-border-color: #6E2926; -fx-border-width: 2;");

		});

		button.setOnMouseExited((e) -> {

			button.setStyle(
					"-fx-background-radius: 10; -fx-background-color: #A02941; -fx-border-radius: 10; -fx-border-color: #6E2926; -fx-border-width: 2;");

		});
	}

	public static Image makeTransparent(Image inputImage) {
		int W = (int) inputImage.getWidth();
		int H = (int) inputImage.getHeight();
		WritableImage outputImage = new WritableImage(W, H);
		PixelReader reader = inputImage.getPixelReader();
		PixelWriter writer = outputImage.getPixelWriter();
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				int argb = reader.getArgb(x, y);

				int r = (argb >> 16) & 0xFF;
				int g = (argb >> 8) & 0xFF;
				int b = argb & 0xFF;

				if (r >= Configuration.TOLERANCE_THRESHOLD && g >= Configuration.TOLERANCE_THRESHOLD
						&& b >= Configuration.TOLERANCE_THRESHOLD) {
					argb &= 0x00FFFFFF;
				}

				writer.setArgb(x, y, argb);
			}
		}

		return outputImage;
	}

	public static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    ObservableList<Node> children = gridPane.getChildren();
	    for (Node node : children) {
	        Integer columnIndex = GridPane.getColumnIndex(node);
	        Integer rowIndex = GridPane.getRowIndex(node);

	        if (columnIndex == null)
	            columnIndex = 0;
	        if (rowIndex == null)
	            rowIndex = 0;

	        if (columnIndex == col && rowIndex == row) {
	            return node;
	        }
	    }
	    return null;
	}
}
