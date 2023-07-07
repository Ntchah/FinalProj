package scene;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import resource.AudioManager;
import resource.AudioManager.Audios;
import resource.FontManager;
import resource.FontManager.Fonts;
import utility.Configuration;
import utility.UtilityGUI;

public class GameButton extends Button {
	
	public GameButton(String name, double width, double height) {
		
		setPrefSize(width, height);
		setText(name);
		setFont(FontManager.getFont(Fonts.BUTTON));
		setTextFill(Color.web("#EEF7EB"));
		setStyle(Configuration.BUTTON_SETTING);
		
		UtilityGUI.buttonHovered(this);
		
		setOnAction((e) -> {
			
			AudioManager.getSoundTrack(Audios.BUTTON_CLICKED).play();
			MainMenuScene.getRoot().getChildren().remove(getParent().getParent().getParent());
			
		});
		
	}
	

}
