package MarsRover;

import MarsRover.Math.Vector2D;

public class Move {

	private Rover _rover;

	private Vector2D getFacingVector(Coordinates direction) {
		switch (direction.direction) {
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
		System.out.println("Rover coordinates (X,Y): (" + roverCoordinates.position + ")");
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
		roverCoordinates.position.sum(getFacingVector(roverCoordinates));
	}

	private void moveBackward(Coordinates roverCoordinates)
	{
		roverCoordinates.position.subtract(getFacingVector(roverCoordinates));
	}

	public void setRover(Rover rover)
	{
		this._rover = rover;
	}
}
