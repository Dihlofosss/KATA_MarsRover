package MarsRover.Commands;

import MarsRover.Rover;
import MarsRover.World.Coordinates;

class Turn extends Coordinates {
	private Rover _rover;


	void turn(char direction)
	{
		Direction _currentDirection = _rover.getPositionDirection().getDirection();
		switch (direction)
		{
			case 'L':
				_currentDirection = _currentDirection.prew(); break;
			case 'R':
				_currentDirection = _currentDirection.next(); break;
		}
		this._rover.setDirection(_currentDirection);
	}

	void set_rover(Rover rover)
	{
		this._rover = rover;
	}
}