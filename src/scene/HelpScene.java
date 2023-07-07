package scene;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import resource.FontManager;
import resource.ImageManager;
import resource.FontManager.Fonts;
import resource.ImageManager.Images;
import utility.Configuration;

public class HelpScene extends StackPane {

	private static final double WIDTH = Configuration.MENU_PANEL_WIDTH;
	private static final double HEIGHT = Configuration.MENU_PANEL_HEIGHT;
	private MenuPanel panel;
	
	public HelpScene() {
		
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
		
		Label header = new Label("Help");
		header.setFont(FontManager.getFont(Fonts.TITLE_MENU_PANEL));
		header.setTextFill(Color.web("#F1EAFC"));
		
		panel.getTopPart().setSpacing(227);
		
		panel.getTopPart().getChildren().add(header);
		
	}
	
	private void setCenter() {
		
		Label label = new Label("Place your preferred type of tower to defend all the balloons!!");
		Label label2 = new Label("DartShooter,Ninja,Sniper can be placed on land and Scubadiver in water!");
		Label label3 = new Label("complete all 12 rounds to win.HOW EASY IT IS");
		
		label.setFont(FontManager.getFont(Fonts.HELP_TEXT));
		label2.setFont(FontManager.getFont(Fonts.HELP_TEXT));
		label3.setFont(FontManager.getFont(Fonts.HELP_TEXT));
		
		ImageView image = ImageManager.getImageView(Images.HELP_SCENE, 400, 250);
		panel.getMiddlePart().setSpacing(15);
		panel.getMiddlePart().getChildren().addAll(label, label2, label3, image);
		
	}
	
	private void setBottom() {
		
		panel.setBottom(null);
		
	}

}
