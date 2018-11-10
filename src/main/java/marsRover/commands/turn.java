package marsRover.commands;

import marsRover.rover;
import marsRover.world.coordinates;

class turn extends coordinates {
	private rover rover;


	void turn(char direction)
	{
		Direction currentDirection = rover.getPositionDirection().getDirection();
		switch (direction)
		{
			case 'L':
				currentDirection = currentDirection.prew(); break;
			case 'R':
				currentDirection = currentDirection.next(); break;
			default:
				System.err.println("Unknown turn command");
				break;
		}
		this.rover.setDirection(currentDirection);
	}

	void setRover(rover rover)
	{
		this.rover = rover;
	}
}