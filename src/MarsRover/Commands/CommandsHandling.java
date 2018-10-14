package MarsRover.Commands;

import java.util.ArrayList;

import MarsRover.Coordinates;
import MarsRover.Move;
import MarsRover.Rover;
import MarsRover.Turn;

public class CommandsHandling {

	private Rover _rover;
	private Coordinates _coordinates;

	public CommandsHandling(Rover rover, Coordinates coordinates)
	{
		this._rover = rover;
		this._coordinates = coordinates;
		this._rover.setPositionDirection(this._coordinates);
	}

	public void executeCommandsList(ArrayList<Character> listOfCommands)
	{
		System.out.println(listOfCommands);
		Move move = new Move();
		Turn turn = new Turn();

		turn.set_rover(this._rover);
		move.setRover(this._rover);
		for (int i = 0; i < listOfCommands.size(); i++)
		{
			char ch = listOfCommands.get(i);
			switch (ch){
				case 'F':
				case 'B':
					move.move(ch); break;
				case 'L':
				case 'R':
					turn.turn(ch); break;
			}
		}
	}
}