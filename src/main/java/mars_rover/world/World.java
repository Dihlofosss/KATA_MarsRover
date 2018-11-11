package mars_rover.world;

import mars_rover.math.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class World {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	private ArrayList<Vector2D> obstacleList = new ArrayList<>();

	public World(){}

	public World(int x, int y)
	{
		this.maxX = x;
		this.minX = -x;
		this.maxY = y;
		this.minY = -y;
	}

	public World(int minX, int maxX, int minY, int maxY)
	{
		this.maxX = maxX;
		this.minX = minX;
		this.maxY = maxY;
		this.minY = minY;
	}

	public void setWorldSize(int x, int y)
	{
		this.maxX = x;
		this.minX = -x;
		this.maxY = y;
		this.minY = -y;
	}

	public void setWorldSize(int minX, int maxX, int minY, int maxY)
	{
		this.maxX = maxX;
		this.minX = minX;
		this.maxY = maxY;
		this.minY = minY;
	}

	public World getWorldSize()
	{
		return this;
	}

	public int getMinX()
	{
		return this.minX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void addObstacle(int x, int y)
	{
		obstacleList.add(new Vector2D(x, y));
	}

	public List<Vector2D> getObstacleList() {
		return obstacleList;
	}

	public void eraseObstacleList()
	{
		this.obstacleList.clear();
	}
}
