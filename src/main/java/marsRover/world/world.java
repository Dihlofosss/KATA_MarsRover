package marsRover.world;

import marsRover.math.vector2D;

import java.util.ArrayList;

public class world {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	private ArrayList<vector2D> obstacleList = new ArrayList<>();

	public world(){}

	public world(int x, int y)
	{
		this.maxX = x;
		this.minX = -x;
		this.maxY = y;
		this.minY = -y;
	}

	public world(int minX, int maxX, int minY, int maxY)
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

	public world getWorldSize()
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
		obstacleList.add(new vector2D(x, y));
	}

	public ArrayList<vector2D> getObstacleList() {
		return obstacleList;
	}

	public void eraseObstacleList()
	{
		this.obstacleList.clear();
	}
}
