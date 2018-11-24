package mars_rover.commands;

import mars_rover.math.Vector2D;
import mars_rover.Rover;
import mars_rover.world.*;

import java.util.logging.Logger;

class Move {
	private Logger logger = Logger.getLogger(getClass().getName());
	private Rover rover;
	private World world;

	private Vector2D getFacingVector(Coordinates direction) {
		switch (direction.getDirection()) {
			case NORTH:
				return new Vector2D(0, 1);
			case EAST:
				return new Vector2D(1, 0);
			case SOUTH:
				return new Vector2D(0, -1);
			case WEST:
				return new Vector2D(-1, 0);
		}
		return null;
	}

	void move(char direction) {
		Vector2D moveVector = getFacingVector(rover.getPositionDirection());
		if (direction == 'B' && moveVector != null)
		{
			moveVector.invert();
		}
		moveWithVector(moveVector);
	}

	private void moveWithVector(Vector2D moveVector)
	{
		Vector2D roverCurrentPosition = rover.getPositionDirection().getPosition();
		Vector2D nextWayPointCoordinates = new Vector2D().sum(roverCurrentPosition, moveVector);

		for (Vector2D obstaclePoint: world.getObstacleList())
		{
			if (obstaclePoint.equals(nextWayPointCoordinates))
			{
				logger.info("Facing obstacle, can't Move further");
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

	void setRover(Rover rover)
	{
		this.rover = rover;
	}

	void setWorld(World world)
	{
		this.world = world;
	}
}
