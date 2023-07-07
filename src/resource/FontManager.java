package resource;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.text.Font;

public class FontManager {

	private static Map<Fonts, Font> fontResources = new HashMap<Fonts, Font>();
	
	public enum Fonts {
		
		TITLE_MENU_PANEL, BUTTON, TEXT, BUYING_TEXT, SETTING, ROUND_SHOWING, TIME_TEXT, CREDITS, BASEDON, HELP_TEXT
	}
	
	static {
		
		loadFonts();
		System.out.println("Fonts have successfully been loaded");
		
	}
	
	private static Font getFont(String path, double size) {
		
		return Font.loadFont(ClassLoader.getSystemClassLoader().getResourceAsStream(path), size);
		
	}
	
	public static void loadFonts() {
		
		fontResources.put(Fonts.TITLE_MENU_PANEL, getFont("font/button.ttf", 36));
		fontResources.put(Fonts.BUTTON, getFont("font/button.ttf", 20));
		fontResources.put(Fonts.TEXT, getFont("font/menu.otf", 32));
		fontResources.put(Fonts.BUYING_TEXT, getFont("font/text.ttf", 16));
		fontResources.put(Fonts.SETTING, getFont("font/text.ttf", 26));
		fontResources.put(Fonts.ROUND_SHOWING, getFont("font/round.ttf", 72));
		fontResources.put(Fonts.TIME_TEXT, getFont("font/round.ttf", 30));
		fontResources.put(Fonts.CREDITS, getFont("font/normal_text.ttf", 30));
		fontResources.put(Fonts.BASEDON, getFont("font/normal_text.ttf", 46));
		fontResources.put(Fonts.HELP_TEXT, getFont("font/normal_text.ttf", 22));

		
	}
	
	public static Font getFont(Fonts font) {
		
		return fontResources.get(font);
	}

}
