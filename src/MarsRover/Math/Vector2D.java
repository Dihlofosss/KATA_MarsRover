package MarsRover.Math;

public class Vector2D{
	private int x, y;


	public Vector2D() {
	}

	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D(Vector2D vector2D)
	{
		this.x = vector2D.getX();
		this.y = vector2D.getY();
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D set(Vector2D vector2D)
	{
		this.x = vector2D.getX();
		this.y = vector2D.getY();
		return this;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Vector2D zero() {
		this.x = 0;
		this.y = 0;
		return this;
	}
/*
	public void sum(Vector2D v1) {
		this.x += v1.x;
		this.y += v1.y;
	}
	*/
	public Vector2D sum(Vector2D v1)
	{
		this.x += v1.x;
		this.y += v1.y;
		return this;
	}

	public Vector2D sum(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.x + v2.x, v1.y + v2.y);
	}

	public void subtract(Vector2D v1) {
		this.x -= v1.x;
		this.y -= v1.y;
	}

	public Vector2D subtract(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.x - v2.x, v1.y - v2.y);
	}

	public void invert()
	{
		this.x *= -1;
		this.y *= -1;
	}

	@Override
	public String toString() {
		return "Vector2d[" + x + "," + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Vector2D && x == (((Vector2D)obj).x) && y == (((Vector2D)obj).y);
	}
}
