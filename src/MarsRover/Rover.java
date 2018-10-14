package MarsRover;

import MarsRover.Math.Vector2D;

public class Rover {
	private Coordinates _coordinates;

	public void setPositionDirection(Coordinates value) {
		_coordinates = value;
	}

	public void setPositionDirection(Vector2D position, Coordinates.Direction direction)
	{
		this._coordinates.position = position;
		this._coordinates.direction = direction;
	}

	public void setDirection(Coordinates.Direction direction)
	{
		this._coordinates.direction = direction;
	}

	public Coordinates getPositionDirection() {
		return this._coordinates;
	}
}