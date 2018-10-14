package MarsRover.World;

public class World {
	private int _minX, _minY, _maxX, _maxY;

	public World(){}

	public World(int x, int y)
	{
		this._maxX = x;
		this._minX = -x;
		this._maxY = y;
		this._minY = -y;
	}

	public World(int minX, int maxX, int minY, int maxY)
	{
		this._maxX = maxX;
		this._minX = minX;
		this._maxY = maxY;
		this._minY = minY;
	}

	public void setWorldSize(int x, int y)
	{
		this._maxX = x;
		this._minX = -x;
		this._maxY = y;
		this._minY = -y;
	}

	public void setWorldSize(int minX, int maxX, int minY, int maxY)
	{
		this._maxX = maxX;
		this._minX = minX;
		this._maxY = maxY;
		this._minY = minY;
	}

	public World getWorldSize()
	{
		return this;
	}

	public int get_minX()
	{
		return this._minX;
	}

	public int get_maxY() {
		return _maxY;
	}

	public int get_minY() {
		return _minY;
	}

	public int get_maxX() {
		return _maxX;
	}
}
