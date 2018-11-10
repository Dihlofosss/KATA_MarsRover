package marsRover.commands;

import marsRover.math.vector2D;
import marsRover.rover;
import marsRover.world.*;

class move {

	private rover rover;
	private world world;

	private vector2D getFacingVector(coordinates direction) {
		switch (direction.getDirection()) {
			case NORTH:
				return new vector2D(0, 1);
			case EAST:
				return new vector2D(1, 0);
			case SOUTH:
				return new vector2D(0, -1);
			case WEST:
				return new vector2D(-1, 0);
		}
		return null;
	}

	void move(char direction) {
		vector2D moveVector = getFacingVector(rover.getPositionDirection());
		if (direction == 'B' && moveVector != null)
		{
			moveVector.invert();
		}
		move(moveVector);
	}

	private void move(vector2D moveVector)
	{
		vector2D roverCurrentPosition = rover.getPositionDirection().getPosition();
		vector2D nextWayPointCoordinates = new vector2D().sum(roverCurrentPosition, moveVector);

		for (vector2D obstaclePoint: world.getObstacleList())
		{
			if (obstaclePoint.equals(nextWayPointCoordinates))
			{
				System.err.println("Facing obstacle, can't move further");
				rover.setFacingObstacle(true);
				return;
			}
		}
		if (nextWayPointCoordinates.getY() > world.getMaxY()) {
			nextWayPointCoordinates.set(roverCurrentPosition.getX(), world.getMinY());
		}
		if (nextWayPointCoordinates.getY() < world.getMinY()) {
			nextWayPointCoordinates.set(roverCurrentPosition.getX(), world.getMaxY());
		}
		if (nextWayPointCoordinates.getX() > world.getMaxX()) {
			nextWayPointCoordinates.set(world.getMinX(), roverCurrentPosition.getY());
		}
		if (nextWayPointCoordinates.getX() < world.getMinX()) {
			nextWayPointCoordinates.set(world.getMaxX(), roverCurrentPosition.getY());
		}
		roverCurrentPosition.set(nextWayPointCoordinates);
	}

	void setRover(rover rover)
	{
		this.rover = rover;
	}

	void setWorld(world world)
	{
		this.world = world;
	}
}
