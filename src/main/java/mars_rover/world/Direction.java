package mars_rover.world;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	private static Direction[] facing = values();

	public Direction next() {
		return facing[(this.ordinal() + 1) % facing.length];
	}

	public Direction prew() {
		if (this.ordinal() == 0)
			return facing[facing.length - 1];
		return facing[((this.ordinal() - 1) % facing.length)];
	}
}