package mars_rover.world;

import mars_rover.math.Vector2D;

public class Coordinates {

	private Vector2D position ;
	private Direction direction;
	public Coordinates() {
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

	public enum Direction {
		NORTH, EAST, SOUTH, WEST;

		private static Direction[] facing = values();

		public Direction next() {
			return facing[(this.ordinal() + 1) % facing.length];
		}

		public Direction prew() {
			if (this.ordinal() == 0)
				return facing[facing.length - 1];
			return facing[((this.ordinal() - 1) % facing.length)];
		}
	}

	public Vector2D getPosition()
	{
		return this.position;
	}

	public Direction getDirection() {
		return this.direction;
	}
}