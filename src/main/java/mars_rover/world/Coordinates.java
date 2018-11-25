package mars_rover.world;

import mars_rover.math.Vector2D;
import mars_rover.world.Direction;

public class Coordinates {

	private Vector2D position ;
	private Direction direction;

	public Coordinates() {
		position = new Vector2D(0,0);
		direction = Direction.NORTH;
	}

	public Coordinates(Vector2D position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public void setPosition(int x, int y)
	{
		this.position.set(x,y);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setCoordinates(Vector2D position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Coordinates getCoordinates() {
		return this;
	}

	public Vector2D getPosition()
	{
		return this.position;
	}

	public Direction getDirection() {
		return this.direction;
	}
}