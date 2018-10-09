package MarsRover;

import MarsRover.Math.Vector2D;

public class Coordinates{

    public enum cardinalDirection
    {
        North, East, South, West;

        private static cardinalDirection[] _facing = values();
        public cardinalDirection Next()
        {
            System.out.println("Turning right from "+ _facing[(this.ordinal())]);
            return _facing[(this.ordinal()+1) % _facing.length];
        }

        public cardinalDirection Prew()
        {
            System.out.println("Turning left from "+ _facing[(this.ordinal())]);
            if (this.ordinal() == 0)
                return _facing[_facing.length-1];
            return _facing[((this.ordinal()-1) % _facing.length)];
        }
    }

    public Vector2D position;
    public cardinalDirection nesw;

    public Coordinates() {    }

    public Coordinates(Vector2D position, cardinalDirection nesw)
    {
        this.position = position;
        this.nesw = nesw;
    }

    public void setPosition(Vector2D position)
    {
        this.position = position;
    }

    public void setNesw(cardinalDirection nesw)
    {
        this.nesw = nesw;
    }

    public void setCoordinates(Vector2D position, cardinalDirection nesw)
    {
        this.position = position;
        this.nesw = nesw;
    }

    public Coordinates getCoordinates()
    {
        return this;
    }
}
