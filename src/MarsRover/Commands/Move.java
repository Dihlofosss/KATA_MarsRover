package MarsRover.Commands;

import MarsRover.Math.Vector2D;
import MarsRover.Rover;
import MarsRover.World.*;

public class Move {

	private Rover _rover;
	private World _world;

	private Vector2D getFacingVector(Coordinates direction) {
		switch (direction.getDirection()) {
			case North:
				return new Vector2D(0, 1);
			case East:
				return new Vector2D(1, 0);
			case South:
				return new Vector2D(0, -1);
			case West:
				return new Vector2D(-1, 0);
		}
		System.out.println("No facing vector assigned");
		return null;
	}

	public void move(char direction) {
		Coordinates roverCoordinates = _rover.getPositionDirection();
		System.out.println("Rover coordinates (X,Y): (" + roverCoordinates.getPosition() + ")");
		switch (Character.toUpperCase(direction)) {
			case 'F':
				moveForward(roverCoordinates);
				break;
			case 'B':
				moveBackward(roverCoordinates);
				break;
		}
	}

	private void moveForward(Coordinates roverCoordinates)
	{
		switch (roverCoordinates.getDirection())
		{
			case North:
				if (roverCoordinates.getPosition().getY() == _world.get_maxY()) {
					roverCoordinates.setPosition(roverCoordinates.getPosition().getX(), _world.get_minY());
					return;
				}
				break;
			case South:
				if (roverCoordinates.getPosition().getY() == _world.get_minY()) {
					roverCoordinates.setPosition(roverCoordinates.getPosition().getX(), _world.get_maxY());
					return;
				}
				break;
			case East:
				if (roverCoordinates.getPosition().getX() == _world.get_maxX()) {
					roverCoordinates.setPosition(_world.get_minX(), roverCoordinates.getPosition().getY());
					return;
				}
				break;
			case West:
				if (roverCoordinates.getPosition().getX() == _world.get_minX()) {
					roverCoordinates.setPosition(_world.get_maxX(), roverCoordinates.getPosition().getY());
					return;
				}
				break;
		}

		roverCoordinates.getPosition().sum(getFacingVector(roverCoordinates));
	}

	private void moveBackward(Coordinates roverCoordinates)
	{
		switch (roverCoordinates.getDirection())
		{
			case North:
				if (roverCoordinates.getPosition().getY() == _world.get_minY()) {
					roverCoordinates.setPosition(roverCoordinates.getPosition().getX(), _world.get_maxY());
					return;
				}
				break;
			case South:
				if (roverCoordinates.getPosition().getY() == _world.get_maxY()) {
					roverCoordinates.setPosition(roverCoordinates.getPosition().getX(), _world.get_minY());
					return;
				}
				break;
			case East:
				if (roverCoordinates.getPosition().getX() == _world.get_minX()) {
					roverCoordinates.setPosition(_world.get_maxX(), roverCoordinates.getPosition().getY());
					return;
				}
				break;
			case West:
				if (roverCoordinates.getPosition().getX() == _world.get_maxX()) {
					roverCoordinates.setPosition(_world.get_minX(), roverCoordinates.getPosition().getY());
					return;
				}
				break;
		}

		roverCoordinates.getPosition().subtract(getFacingVector(roverCoordinates));
	}

	public void setRover(Rover rover)
	{
		this._rover = rover;
	}

	public void setWorld(World world)
	{
		this._world = world;
	}
}
