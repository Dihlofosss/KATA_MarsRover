package MarsRover;

import MarsRover.Math.Vector2D;
import MarsRover.World.Coordinates;

public class Rover {
	private Coordinates _coordinates;

	public void setPositionDirection(Coordinates value) {
		_coordinates = value;
	}

	public void setPositionDirection(Vector2D position, Coordinates.Direction direction)
	{
		this._coordinates.setPosition(position);
		this._coordinates.setDirection(direction);
	}

	public void setDirection(Coordinates.Direction direction)
	{
		this._coordinates.setDirection(direction);
	}

	public Coordinates getPositionDirection() {
		return this._coordinates;
	}

	@Override
	public String toString() {
		return _coordinates.getPosition() + " " + _coordinates.getDirection();
	}
}