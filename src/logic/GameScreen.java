package logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import resource.ImageManager;
import resource.ImageManager.Images;
import scene.GameScene;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameScreen extends Canvas {

	private GraphicsContext gc;
	public GameScreen(double width, double height) {

		super(width, height);
		this.setVisible(true);

	}

	

	public void paintComponent() {

		gc = getGraphicsContext2D();
		if (GameScene.isDefaultMap()) {
			gc.drawImage(ImageManager.getImage(Images.GRASS_MAP),0, 0, 1000, 508);
		} else {
			gc.drawImage(ImageManager.getImage(Images.SEA_MAP),0, 0, 1000, 508);
		}
		
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}

	public GraphicsContext getGc() {
		return gc;
	}
	
}
