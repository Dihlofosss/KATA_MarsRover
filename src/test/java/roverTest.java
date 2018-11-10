import marsRover.commands.*;
import marsRover.world.*;
import marsRover.math.vector2D;
import marsRover.rover;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class roverTest {

	private world _world = new world(3,3);
	private coordinates _coordinates = new coordinates();
	private coordinates _expectedCoordinates = new coordinates();
	private rover _rover = new rover();
	private vector2D _vector2D = new vector2D();
	private inputCommands _commands;
	private controlCenter _controlCenter;

	@Test
	public void TurnRight() {
		_coordinates.setCoordinates(_vector2D.zero(), coordinates.Direction.WEST);
		_commands = new inputCommands("R");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(_vector2D.zero(), coordinates.Direction.NORTH);
		assertThat(_rover.getPositionDirection().getDirection()).isEqualToComparingFieldByField(_expectedCoordinates.getDirection());
	}

	@Test
	public void TurnLeft() {
		_coordinates.setCoordinates(_vector2D.zero(), coordinates.Direction.NORTH);
		_commands = new inputCommands("L");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D().zero(), coordinates.Direction.WEST);
		assertThat(_rover.getPositionDirection().getDirection()).isEqualToComparingFieldByField(_expectedCoordinates.getDirection());
	}

	@Test
	public void MoveForward() {
		_coordinates.setCoordinates(_vector2D.zero(), coordinates.Direction.NORTH);
		_commands = new inputCommands("F");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(0, 1), coordinates.Direction.NORTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
	}

	@Test
	public void MoveBackward() {
		_coordinates.setCoordinates(new vector2D(1, 2), coordinates.Direction.SOUTH);
		_commands = new inputCommands("B");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(1, 3), coordinates.Direction.SOUTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
	}

	@Test
	public void TurnAndMove()
	{
		_coordinates.setCoordinates(_vector2D.zero(), coordinates.Direction.NORTH);
		_commands = new inputCommands("FRFL");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(1, 1), coordinates.Direction.NORTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void JumpForwardOverTheWorldsEdge()
	{
		_world.setWorldSize(5,5);
		_coordinates.setCoordinates(new vector2D(4,0), coordinates.Direction.EAST);
		_commands = new inputCommands("FFFF");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(-3, 0), coordinates.Direction.EAST);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void JumpBackwardOverTheWorldsEdge()
	{
		_world.setWorldSize(5,5);
		_coordinates.setCoordinates(new vector2D(0,4), coordinates.Direction.SOUTH);
		_commands = new inputCommands("BBBB");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(0, -3), coordinates.Direction.SOUTH);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}

	@Test
	public void ObstacleTest()
	{
		_world.setWorldSize(5,5);
		_world.addObstacle(1,1);
		_coordinates.setCoordinates(new vector2D(0,0), coordinates.Direction.NORTH);
		_commands = new inputCommands("FRFFFF");
		_controlCenter = new controlCenter(_rover, _coordinates, _world);
		_controlCenter.executeCommandsList(_commands.getListOfCommands());
		_expectedCoordinates.setCoordinates(new vector2D(0, 1), coordinates.Direction.EAST);
		assertThat(_rover.getPositionDirection().getPosition()).isEqualToComparingFieldByField(_expectedCoordinates.getPosition());
		assertThat(_rover.getPositionDirection().getDirection()).isEqualTo(_expectedCoordinates.getDirection());
	}
}