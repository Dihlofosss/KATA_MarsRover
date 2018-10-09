package MarsRover;

import MarsRover.Math.Vector2D;

public class Rover
{
    private Coordinates _coordinates;

    private Vector2D GetFacingVector(Coordinates cardinalDirection)
    {
        switch (cardinalDirection.nesw)
        {
            case North: return new Vector2D(0,1);
            case East: return new Vector2D(1,0);
            case South: return new Vector2D(0,-1);
            case West: return new Vector2D(-1,0);
        }
        System.out.println("No facing vector assigned");
        return null;
    }
/*
    public static void main(String[] args)
    {
        Rover rover = new Rover();
        rover._coordinates.setCoordinates(0,0, Directions.North);
        rover.SetPositionDirection(rover._coordinates);
        rover.Turn('R');
        rover.GetPositionDirection();
    }
*/
    public void SetPositionDirection(Coordinates value)
    {
        //SetDirection(value.nesw);
        _coordinates = value;
    }

    public void Move(char direction)
    {
        System.out.println("Rover coordinates (X,Y): (" + _coordinates.position + ")");
        switch (Character.toUpperCase(direction))
        {
            case 'F': _coordinates.position.sum(GetFacingVector(_coordinates)); break;
            case 'B': _coordinates.position.subtract(GetFacingVector(_coordinates)); break;
        }
    }

    public void Turn(char turn)
    {
        switch (Character.toUpperCase(turn))
        {
            case 'R': _coordinates.nesw = _coordinates.nesw.Next(); break;
            case 'L': _coordinates.nesw = _coordinates.nesw.Prew(); break;
        }
    }

    public Coordinates GetPositionDirection()
    {
        System.out.println("Rover coordinates (X,Y): (" + _coordinates.position.x + ";" + _coordinates.position.y + ")");
        System.out.println("Rover facing " + _coordinates.nesw);
        return _coordinates;
    }
}