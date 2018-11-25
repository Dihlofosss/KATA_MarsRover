import mars_rover.commands.*;
import mars_rover.world.*;
import mars_rover.math.Vector2D;
import mars_rover.Rover;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTests {

	private World _world = new World(3,3);
	private Coordinates _coordinates = new Coordinates();
	private Coordinates _expectedCoordinates = new Coordinates();
	private Rover _rover = new Rover();
	private Vector2D _vector2D = new Vector2D();
	private InputCommands _commands;
	private ControlCenter _controlCenter;

	@Test
	public void TurnRight() {
		_coordinates.setCoordinates(_vector2D.zero(), Direction.WEST);
		_commands = new InputCommands("R");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.zero(), Direction.NORTH);
		assertThat(_rover.getPositionDirection().getDirection()).isEqualToComparingFieldByField(_expectedCoordinates.getDirection());
	}

	@Test
	public void TurnLeft() {
		_coordinates.setCoordinates(_vector2D.zero(), Direction.NORTH);
		_commands = new InputCommands("L");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D().zero(), Direction.WEST);
		assertThat(_rover.getPositionDirection().getDirection()).isEqualToComparingFieldByField(_expectedCoordinates.getDirection());
	}

	@Test
	public void MoveForward() {
		_coordinates.setCoordinates(_vector2D.zero(), Direction.NORTH);
		_commands = new InputCommands("F");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(0, 1), Direction.NORTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
	}

	@Test
	public void MoveBackward() {
		_coordinates.setCoordinates(new Vector2D(1, 2), Direction.SOUTH);
		_commands = new InputCommands("B");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(1, 3), Direction.SOUTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
	}

	@Test
	public void TurnAndMove()
	{
		_coordinates.setCoordinates(_vector2D.zero(), Direction.NORTH);
		_commands = new InputCommands("FRFL");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(1, 1), Direction.NORTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void JumpForwardOverTheWorldsEdge()
	{
		_world.setWorldSize(5,5);
		_coordinates.setCoordinates(new Vector2D(4,0), Direction.EAST);
		_commands = new InputCommands("FFFF");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(-3, 0), Direction.EAST);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void JumpBackwardOverTheWorldsEdge()
	{
		_world.setWorldSize(5,5);
		_coordinates.setCoordinates(new Vector2D(0,4), Direction.SOUTH);
		_commands = new InputCommands("BBBB");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(0, -3), Direction.SOUTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void ObstacleTest()
	{
		_world.setWorldSize(5,5);
		_world.addObstacle(1,1);
		_coordinates.setCoordinates(new Vector2D(0,0), Direction.NORTH);
		_commands = new InputCommands("FRFFFF");
		_controlCenter = new ControlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new Vector2D(0, 1), Direction.EAST);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}
}