package logic;

public class Position {

	private double x;
	private double y;
	private boolean canMove;

	public Position(double x, double y) {
		this.setX(x);
		this.setY(y);
		canMove = true;
	}

	public Position(Position pos) {
		this(pos.getX(), pos.getY());
	}

	public void move(double dx, double dy) {
		if (canMove) {
			this.setX(this.getX() + dx);
			this.setY(this.getY() + dy);
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setCanMove(boolean moveable) {
		this.canMove = moveable;
	}

}
