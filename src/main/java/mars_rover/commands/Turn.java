package mars_rover.commands;

import mars_rover.Rover;
import mars_rover.world.Coordinates;
import mars_rover.world.Direction;

import java.util.logging.Logger;

class Turn extends Coordinates {
	private Rover rover;
	private Logger logger = Logger.getLogger(getClass().getName());

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
				logger.info("Unknown turnDirection command " + direction);
				break;
		}
		this.rover.setDirection(currentDirection);
	}

	void setRover(Rover rover)
	{
		this.rover = rover;
	}
}