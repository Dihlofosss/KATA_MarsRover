package MarsRover;

public class Turn extends Coordinates{
	private Direction _currentDirection;
	private Rover _rover;


	public void turn(char direction)
	{
		_currentDirection = _rover.getPositionDirection().direction;
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
		_currentDirection = this._rover.getPositionDirection().direction;
	}

	public void set_rover(Rover rover)
	{
		this._rover = rover;
	}
}