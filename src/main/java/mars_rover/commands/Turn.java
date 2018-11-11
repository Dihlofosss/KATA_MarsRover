package mars_rover.commands;

import mars_rover.Rover;
import mars_rover.world.Coordinates;

class Turn extends Coordinates {
	private Rover rover;


	void turnDirection(char direction)
	{
		Direction currentDirection = rover.getPositionDirection().getDirection();
		switch (direction)
		{
			case 'L':
				currentDirection = currentDirection.prew(); break;
			case 'R':
				currentDirection = currentDirection.next(); break;
			default:
				System.err.println("Unknown turnDirection command");
				break;
		}
		this.rover.setDirection(currentDirection);
	}

	void setRover(Rover rover)
	{
		this.rover = rover;
	}
}