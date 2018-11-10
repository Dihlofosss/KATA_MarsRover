package marsRover;

import marsRover.math.vector2D;
import marsRover.world.coordinates;

public class rover {
	private coordinates coordinates;
	private boolean facingObstacle = false;

	public void setPositionDirection(coordinates value) {
		coordinates = value;
	}

	public void setPositionDirection(vector2D position, coordinates.Direction direction)
	{
		this.coordinates.setPosition(position);
		this.coordinates.setDirection(direction);
	}

	public void setDirection(coordinates.Direction direction)
	{
		this.coordinates.setDirection(direction);
	}

	public void setFacingObstacle(boolean facingObstacle) {
		this.facingObstacle = facingObstacle;
	}

	public coordinates getPositionDirection() {
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