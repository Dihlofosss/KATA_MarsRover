package MarsRover.World;

import MarsRover.Math.Vector2D;

public class Coordinates {

	private Vector2D position;
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
		North, East, South, West;

		private static Direction[] _facing = values();

		public Direction next() {
			System.out.println("Turning right from " + _facing[(this.ordinal())]);
			return _facing[(this.ordinal() + 1) % _facing.length];
		}

		public Direction prew() {
			System.out.println("Turning left from " + _facing[(this.ordinal())]);
			if (this.ordinal() == 0)
				return _facing[_facing.length - 1];
			return _facing[((this.ordinal() - 1) % _facing.length)];
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