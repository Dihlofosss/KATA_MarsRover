import MarsRover.Coordinates;
import MarsRover.Math.Vector2D;
import MarsRover.Rover;
import org.junit.*;
import static  org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    private Coordinates _coordinates = new Coordinates();
    private Coordinates _expectedCoordinates = new Coordinates();
    private Rover _rover = new Rover();
    private Vector2D _vector2D = new Vector2D();

    @Test
    public void TurnRight()
    {
        _coordinates.setCoordinates(_vector2D.zero(), Coordinates.cardinalDirection.West);
        _rover.SetPositionDirection(_coordinates);
        _rover.Turn('R');
        _expectedCoordinates.setCoordinates(_vector2D.zero(), Coordinates.cardinalDirection.North);
        assertThat(_rover.GetPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
    }

    @Test
    public void TurnLeft()
    {
        _coordinates.setCoordinates(_vector2D.zero(), Coordinates.cardinalDirection.North);
        _rover.SetPositionDirection(_coordinates);
        _rover.Turn('L');
        _expectedCoordinates.setCoordinates(_vector2D.zero(), Coordinates.cardinalDirection.West);
        assertThat(_rover.GetPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
    }

    @Test
    public void MoveForward()
    {
        _coordinates.setCoordinates(_vector2D.zero(), Coordinates.cardinalDirection.North);
        _rover.SetPositionDirection(_coordinates);
        _rover.Move('F');
        _expectedCoordinates.setCoordinates(_vector2D.set(0,1), Coordinates.cardinalDirection.North);
        assertThat(_rover.GetPositionDirection()).isEqualToComparingFieldByField(_expectedCoordinates);
    }
}