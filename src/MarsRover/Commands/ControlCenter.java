package MarsRover.Commands;

import java.util.ArrayList;

import MarsRover.World.*;
import MarsRover.Rover;

public class ControlCenter {

	private Rover _rover;
	private World _world;

	public ControlCenter(Rover rover, Coordinates coordinates, World world)
	{
		this._world = world;
		this._rover = rover;
		this._rover.setPositionDirection(coordinates);
	}

	public void executeCommandsList(ArrayList<Character> listOfCommands)
	{
		System.out.println(listOfCommands);
		Move move = new Move();
		Turn turn = new Turn();

		turn.set_rover(this._rover);
		move.setRover(this._rover);
		move.setWorld(this._world);

		for (Character listOfCommand : listOfCommands) {
			if (_rover.is_facingObstacle())
				return;
			System.out.println(_rover.toString());
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
			}
		}
	}
	public Rover getRover()
	{
		return this._rover;
	}
}