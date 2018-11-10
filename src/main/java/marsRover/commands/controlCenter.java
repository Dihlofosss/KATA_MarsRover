package marsRover.commands;

import java.util.List;

import marsRover.world.*;
import marsRover.rover;

public class controlCenter {

	private rover rover;
	private world world;

	public controlCenter(rover rover, coordinates coordinates, world world)
	{
		this.world = world;
		this.rover = rover;
		this.rover.setPositionDirection(coordinates);
	}

	public void executeCommandsList(List<Character> listOfCommands)
	{
		move move = new move();
		turn turn = new turn();

		turn.setRover(this.rover);
		move.setRover(this.rover);
		move.setWorld(this.world);

		for (Character listOfCommand : listOfCommands) {
			if (rover.isFacingObstacle())
				return;
			char ch = listOfCommand;
			switch (ch) {
				case 'F':
				case 'B':
					move.move(ch);
					break;
				case 'L':
				case 'R':
					turn.turn(ch);
					break;
				default:
					System.err.println("Unknown command move/turn");
					break;
			}
		}
	}
	public rover getRover()
	{
		return this.rover;
	}
}