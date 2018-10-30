package MarsRover.World;

import MarsRover.Math.Vector2D;

import java.util.ArrayList;

public class World {
	private int _minX, _minY, _maxX, _maxY;
	private ArrayList<Vector2D> obstacleList = new ArrayList<Vector2D>();

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

	public void addObstacle(int x, int y)
	{
		obstacleList.add(new Vector2D(x, y));
	}

	public ArrayList<Vector2D> getObstacleList() {
		return obstacleList;
	}

	public void eraseObstacleList()
	{
		this.obstacleList.clear();
	}
}
