package edu.projects;

public class Location {
	private final static int wall = 0;
	private final static int free = 1;
	private final static int destination = 2;
	
	private int x;
	private int y;
	private static int width;
	private static int height;
	private int type;
	
	
	public Location(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public static int getWidtht() {
		return width;
	}
	public static void setWidth(int width) {
		Location.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		Location.height = height;
	}
}
