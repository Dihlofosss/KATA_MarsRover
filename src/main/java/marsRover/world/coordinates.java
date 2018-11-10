package marsRover.world;

import marsRover.math.vector2D;

public class coordinates {

	private vector2D position ;
	private Direction direction;
	public coordinates() {
	}

	public coordinates(vector2D position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public void setPosition(vector2D position) {
		this.position = position;
	}

	public void setPosition(int x, int y)
	{
		this.position.set(x,y);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setCoordinates(vector2D position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public coordinates getCoordinates() {
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

	public vector2D getPosition()
	{
		return this.position;
	}

	public Direction getDirection() {
		return this.direction;
	}
}