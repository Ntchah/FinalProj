package resource;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageManager {

	private static Map<Images, Image> imageResources = new HashMap<Images, Image>();

	public enum Images {

		LOGO, DARTSHOOTER, SNIPER, NINJA, SCUBADIVER, GRASS_MAP, SEA_MAP, MAIN_MENU, BACKGROUND, BACKGROUND2,
		BACKGROUND3, BACKGROUND4, SNIPERBULLET, BOMB, SHURIKEN, DART, RED_BALLOON, BLUE_BALLOON, GREEN_BALLOON,
		YELLOW_BALLOON, PINK_BALLOON, WHITE_BALLOON, BLACK_BALLOON, PURPLE_BALLOON, ZEBRA_BALLOON, LEAD_BALLOON,
		RAINBOW_BALLOON, CERAMIC_BALLOON, TOPPER, WIN_SCENE, LOSE_SCENE, SNIPER_BULLET, BLOON_LOGO, HELP_SCENE

	}

	static {

		loadImages();
		System.out.println("Images have successfull been loaded");

	}

	private static Image getImage(String path, double width, double height) {

		return new Image(ClassLoader.getSystemResource(path).toString(), width, height, true, true);

	}

	private static Image getImage(String path) {

		return new Image(ClassLoader.getSystemResource(path).toString());

	}

	public static void loadImages() {

		imageResources.put(Images.LOGO, getImage("image/logo.png"));
		imageResources.put(Images.DARTSHOOTER, getImage("image/dart.png", 60, 60));
		imageResources.put(Images.NINJA, getImage("image/ninja.png", 60, 60));
		imageResources.put(Images.SNIPER, getImage("image/sniper.png", 60, 70));
		imageResources.put(Images.SCUBADIVER, getImage("image/scuba.png", 60, 70));
		imageResources.put(Images.GRASS_MAP, getImage("image/grass_map.png"));
		imageResources.put(Images.SEA_MAP, getImage("image/sea_map.PNG"));
		imageResources.put(Images.WIN_SCENE, getImage("image/lose.png"));
		imageResources.put(Images.LOSE_SCENE, getImage("image/win.png"));
		imageResources.put(Images.RED_BALLOON, getImage("image/red.png", 60, 60));
		imageResources.put(Images.BLUE_BALLOON, getImage("image/blue.png", 60, 60));
		imageResources.put(Images.GREEN_BALLOON, getImage("image/green.png", 60, 60));
		imageResources.put(Images.YELLOW_BALLOON, getImage("image/yellow.png", 60, 60));
		imageResources.put(Images.PINK_BALLOON, getImage("image/pink.png", 60, 60));
		imageResources.put(Images.PURPLE_BALLOON, getImage("image/purple.png", 60, 60));
		imageResources.put(Images.WHITE_BALLOON, getImage("image/white.png", 60, 60));
		imageResources.put(Images.BLACK_BALLOON, getImage("image/black.png", 60, 60));
		imageResources.put(Images.ZEBRA_BALLOON, getImage("image/zebra.png", 60, 60));
		imageResources.put(Images.LEAD_BALLOON, getImage("image/steellead.png", 60, 60));
		imageResources.put(Images.RAINBOW_BALLOON, getImage("image/rainbow.png", 60, 60));
		imageResources.put(Images.CERAMIC_BALLOON, getImage("image/ceramic.png", 60, 60));
		imageResources.put(Images.MAIN_MENU, getImage("image/menu.jpeg"));
		imageResources.put(Images.BACKGROUND, getImage("image/menuWithoutLogo.jpeg"));
		imageResources.put(Images.BACKGROUND2, getImage("image/bg2.png"));
		imageResources.put(Images.BACKGROUND3, getImage("image/bg3.jpg"));
		imageResources.put(Images.BACKGROUND4, getImage("image/bg4.jpg"));
		imageResources.put(Images.TOPPER, getImage("image/topper.png"));
		imageResources.put(Images.DART, getImage("image/dart_bullet.png", 25, 25));
		imageResources.put(Images.BOMB, getImage("image/bomb.png", 20, 20));
		imageResources.put(Images.SHURIKEN, getImage("image/shuriken.png", 20, 20));
		imageResources.put(Images.SNIPER_BULLET, getImage("image/sniper_bullet.png", 20, 20));
		imageResources.put(Images.BLOON_LOGO, getImage("image/logo_balloon.png"));
		imageResources.put(Images.HELP_SCENE, getImage("image/help.png"));
		
	}

	public static Image getImage(Images image) {

		return imageResources.get(image);
	}

	public static ImageView getImageView(Images image, int width, int height) {

		ImageView imageView = new ImageView(getImage(image));

		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		return imageView;

	}

}
