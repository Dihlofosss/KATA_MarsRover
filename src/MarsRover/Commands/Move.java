package MarsRover.Commands;

import MarsRover.Math.Vector2D;
import MarsRover.Rover;
import MarsRover.World.*;

class Move {

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

	void move(char direction) {
		Vector2D moveVector = getFacingVector(_rover.getPositionDirection());
		if (direction == 'B' && moveVector != null)
		{
			moveVector.invert();
		}
		move(moveVector);
	}

	private void move(Vector2D moveVector)
	{
		Vector2D roverCurrentPosition = _rover.getPositionDirection().getPosition();
		Vector2D nextWayPointCoordinates = new Vector2D().sum(roverCurrentPosition, moveVector);

		for (Vector2D obstaclePoint: _world.getObstacleList())
		{
			if (obstaclePoint.equals(nextWayPointCoordinates))
			{
				System.out.println("Facing obstacle, can't move further");
				//execute some stop shit
				_rover.set_facingObstacle(true);
				return;
			}
		}
		if (nextWayPointCoordinates.getY() > _world.get_maxY()) {
			nextWayPointCoordinates.set(roverCurrentPosition.getX(), _world.get_minY());
		}
		if (nextWayPointCoordinates.getY() < _world.get_minY()) {
			nextWayPointCoordinates.set(roverCurrentPosition.getX(), _world.get_maxY());
		}
		if (nextWayPointCoordinates.getX() > _world.get_maxX()) {
			nextWayPointCoordinates.set(_world.get_minX(), roverCurrentPosition.getY());
		}
		if (nextWayPointCoordinates.getX() < _world.get_minX()) {
			nextWayPointCoordinates.set(_world.get_maxX(), roverCurrentPosition.getY());
		}
		roverCurrentPosition.set(nextWayPointCoordinates);
		System.out.println("Rover new coordinates " + roverCurrentPosition);
	}

	void setRover(Rover rover)
	{
		this._rover = rover;
	}

	void setWorld(World world)
	{
		this._world = world;
	}
}
