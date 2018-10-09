package MarsRover.Math;

public class Vector2D {
    public int x,y;

    public Vector2D() { }

    public Vector2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D set(int x, int y)
    {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D zero()
    {
        this.x = 0;
        this.y = 0;
        return this;
    }

    public void sum(Vector2D v1){
        this.x+=v1.x;
        this.y+=v1.y;
    }

    public Vector2D sum(Vector2D v1, Vector2D v2)
    {
        return new Vector2D(v1.x + v2.x,v1.y + v2.y);
    }

    public void subtract(Vector2D v1)
    {
        this.x-=v1.x;
        this.y-=v1.y;
    }

    public Vector2D subtract(Vector2D v1, Vector2D v2)
    {
        return new Vector2D(v1.x - v2.x,v1.y - v2.y);
    }

    @Override
    public String toString()
    {
        return "Vector2d[" + x + "," + y + "]";
    }
}
