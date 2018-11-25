package mars_rover;

import mars_rover.world.Coordinates;
import mars_rover.world.Direction;

public class Rover {
	private Coordinates coordinates;
	private boolean facingObstacle = false;

	public void setPositionDirection(Coordinates value) {
		coordinates = value;
	}

	public void setDirection(Direction direction)
	{
		this.coordinates.setDirection(direction);
	}

	public void setFacingObstacle(boolean facingObstacle) {
		this.facingObstacle = facingObstacle;
	}

	public Coordinates getPositionDirection() {
		return this.coordinates;
	}

	public boolean isFacingObstacle() {
		return facingObstacle;
	}
}