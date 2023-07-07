package scene;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import resource.FontManager;
import resource.ImageManager;
import resource.ImageManager.Images;
import resource.FontManager.Fonts;
import utility.Configuration;

public class CreditScene extends StackPane {

	private static final double WIDTH = Configuration.MENU_PANEL_WIDTH;
	private static final double HEIGHT = Configuration.MENU_PANEL_HEIGHT;
	private MenuPanel panel;
	
	public CreditScene() {
		
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
		
	}
	
	private void setTopper() {
		
		Label header = new Label("Credit");
		header.setFont(FontManager.getFont(Fonts.TITLE_MENU_PANEL));
		header.setTextFill(Color.web("#F1EAFC"));
		
		panel.getTopPart().setSpacing(215);
		
		panel.getTopPart().getChildren().add(header);
		
	}
	
	private void setCenter() {
		
		VBox creditPanel = new VBox();
		creditPanel.setAlignment(Pos.CENTER);
		creditPanel.setSpacing(25);
		creditPanel.setTranslateY(-15);
		
		Label basedOn = new Label("Based on");
		basedOn.setFont(FontManager.getFont(Fonts.CREDITS));
		
		HBox credits = new HBox();
		credits.setAlignment(Pos.CENTER);
		credits.setSpacing(10);
		
		Label creditsText = new Label("Bloon TD Battle 5");
		creditsText.setFont(FontManager.getFont(Fonts.CREDITS));
		
		credits.getChildren().addAll(ImageManager.getImageView(Images.BLOON_LOGO, 50, 50), creditsText);
		
		Label developer = new Label("Developed by");
		developer.setFont(FontManager.getFont(Fonts.CREDITS));
		developer.setAlignment(Pos.CENTER);
		
		Label firstPerson = new Label("Natcha Hungsapruek");
		firstPerson.setFont(FontManager.getFont(Fonts.CREDITS));
		firstPerson.setAlignment(Pos.CENTER);
		
		Label secondPerson = new Label("Dalai Jotisalikorn Surenjargal");
		secondPerson.setFont(FontManager.getFont(Fonts.CREDITS));
		secondPerson.setAlignment(Pos.CENTER);
		
		Label subject = new Label("2110215 Programming Methodology 2 / 2022");
		subject.setFont(FontManager.getFont(Fonts.CREDITS));
		subject.setAlignment(Pos.CENTER);
		
		creditPanel.getChildren().addAll(basedOn, credits, developer, firstPerson, secondPerson, subject);
		
		panel.getMiddlePart().getChildren().add(creditPanel);
		
		
	}
	
	private void setBottom() {
		
		panel.setBottom(null);
		
		
	}

	
}
