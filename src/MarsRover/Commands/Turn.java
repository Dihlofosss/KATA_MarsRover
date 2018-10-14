package MarsRover.Commands;

import MarsRover.Rover;
import MarsRover.World.Coordinates;

public class Turn extends Coordinates {
	private Direction _currentDirection;
	private Rover _rover;


	public void turn(char direction)
	{
		_currentDirection = _rover.getPositionDirection().getDirection();
		switch (direction)
		{
			case 'L':
				_currentDirection = _currentDirection.prew(); break;
			case 'R':
				_currentDirection = _currentDirection.next(); break;
		}
		this._rover.setDirection(_currentDirection);
	}

	private void getCurrentDirection()
	{
		_currentDirection = this._rover.getPositionDirection().getDirection();
	}

	public void set_rover(Rover rover)
	{
		this._rover = rover;
	}
}