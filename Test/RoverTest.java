import MarsRover.Commands.*;
import MarsRover.Coordinates;
import MarsRover.Math.Vector2D;
import MarsRover.Rover;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

	private Coordinates _coordinates = new Coordinates();
	private Coordinates _expectedCoordinates = new Coordinates();
	private Rover _rover = new Rover();
	private Vector2D _vector2D = new Vector2D();
	private InputCommands _commands;
	private CommandsHandling _handledCommands;

	@Test
	public void TurnRight() {
		_coordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.West);
		_commands = new InputCommands("R");
		_handledCommands = new CommandsHandling(_rover, _coordinates);
		_handledCommands.executeCommandsList(_commands.get_listOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.North);
		assertThat(_rover.getPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
	}

	@Test
	public void TurnLeft() {
		_coordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.North);
		_commands = new InputCommands("L");
		_handledCommands = new CommandsHandling(_rover, _coordinates);
		_handledCommands.executeCommandsList(_commands.get_listOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.West);
		assertThat(_rover.getPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
	}

	@Test
	public void MoveForward() {
		_coordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.North);
		_commands = new InputCommands("F");
		_handledCommands = new CommandsHandling(_rover, _coordinates);
		_handledCommands.executeCommandsList(_commands.get_listOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.set(0, 1), Coordinates.Direction.North);
		assertThat(_rover.getPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
	}

	@Test
	public void MoveBackward() {
		_coordinates.setCoordinates(_vector2D.set(1, 2), Coordinates.Direction.South);
		_commands = new InputCommands("B");
		_handledCommands = new CommandsHandling(_rover, _coordinates);
		_handledCommands.executeCommandsList(_commands.get_listOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.set(1, 1), Coordinates.Direction.South);
		assertThat(_rover.getPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
	}

	@Test
	public void TurnAndMove()
	{
		_coordinates.setCoordinates(_vector2D.zero(), Coordinates.Direction.North);
		_commands = new InputCommands("FRFL");
		_handledCommands = new CommandsHandling(_rover, _coordinates);
		_handledCommands.executeCommandsList(_commands.get_listOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.set(1, 1), Coordinates.Direction.North);
		assertThat(_rover.getPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
	}
}