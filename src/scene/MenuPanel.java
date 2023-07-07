package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MenuPanel extends BorderPane {

	private GameButton returnButton;
	private HBox topPart, bottomPart;
	private VBox middlePart;
	
	public MenuPanel(double width, double height) {
		
		setMaxSize(width, height);
		setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		setStyle("-fx-background-radius: 18; -fx-background-color: #6CA5C8; -fx-border-color: #1C346F; -fx-border-radius: 18; -fx-border-width: 2;");
		
		topPart = new HBox();
		topPart.setAlignment(Pos.CENTER_LEFT);
		topPart.setPrefSize(width, height * 0.15);
		topPart.setSpacing(200);
		topPart.setStyle("-fx-background-radius: 15 15 0 0; -fx-background-color: #1C346F;");
		setReturnButton();
		
		middlePart = new VBox();
		middlePart.setAlignment(Pos.TOP_CENTER);
		middlePart.setTranslateY(30);
		middlePart.setSpacing(40);
		
		bottomPart = new HBox();
		bottomPart.setAlignment(Pos.CENTER);
		bottomPart.setPrefSize(width, height * 0.15);
		bottomPart.setSpacing(50);
		bottomPart.setStyle("-fx-background-radius: 0 0 15 15; -fx-background-color: #1C346F;");
		
		setTop(topPart);
		setBottom(bottomPart);
		setCenter(middlePart);
		
	}
	
	private void setReturnButton() {
		
		returnButton = new GameButton("<", 60, 20);
		
		HBox.setMargin(returnButton, new Insets(0, 0, 0, 10));
		getTopPart().getChildren().add(returnButton);
		
	}
	

	public VBox getMiddlePart() {
		return middlePart;
	}

	public HBox getTopPart() {
		return topPart;
	}

	public HBox getBottomPart() {
		return bottomPart;
	}

	public Button getReturnButton() {
		return returnButton;
	}
	
	
}
