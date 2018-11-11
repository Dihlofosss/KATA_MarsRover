package mars_rover;

import mars_rover.math.Vector2D;
import mars_rover.world.Coordinates;

public class Rover {
	private Coordinates coordinates;
	private boolean facingObstacle = false;

	public void setPositionDirection(Coordinates value) {
		coordinates = value;
	}

	public void setPositionDirection(Vector2D position, Coordinates.Direction direction)
	{
		this.coordinates.setPosition(position);
		this.coordinates.setDirection(direction);
	}

	public void setDirection(Coordinates.Direction direction)
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

	@Override
	public String toString() {
		return coordinates.getPosition() + " " + coordinates.getDirection();
	}
}