package mars_rover.commands;

import java.util.List;

import mars_rover.world.*;
import mars_rover.Rover;

public class ControlCenter {

	private Rover rover;
	private World world;

	public ControlCenter(Rover rover, Coordinates coordinates, World world)
	{
		this.world = world;
		this.rover = rover;
		this.rover.setPositionDirection(coordinates);
	}

	public void executeCommandsList(List<Character> listOfCommands)
	{
		Move move = new Move();
		Turn turn = new Turn();

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
					turn.turnDirection(ch);
					break;
				default:
					System.err.println("Unknown command Move/turnDirection");
					break;
			}
		}
	}
	public Rover getRover()
	{
		return this.rover;
	}
}