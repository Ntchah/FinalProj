package sharedObject;

import resource.ImageManager.Images;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Position;

public abstract class Entity implements IRenderable, Updatable {

	protected Images image;
	protected int z;
	protected boolean visible;
	public boolean destroyed;
	private Position pos;
	private int width;
	private int height;
	

	public Entity(Images image, double x, double y) {
		
		this.image = image;
		this.pos = new Position(x, y);
		this.visible = true;
		this.destroyed = false;
		GameLogic.addNewObject(this);
		
	}
	
	@Override
	public abstract void draw(GraphicsContext gc);

	@Override
	public boolean isVisible() {
		
		return this.visible;
		
	}

	@Override
	public int getZ() {
		
		return this.z;
		
	}
	
	public boolean isDestroyed() {
		
		return this.destroyed;
		
	}

	public Position getPos() {
		return pos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Images getImage() {
		return image;
	}
	
	

}
