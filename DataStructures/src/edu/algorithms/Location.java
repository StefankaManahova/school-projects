package edu.algorithms;

public class Location {
	private final static int wall = 0;
	private final static int free = 1;
	private final static int destination = 2;
	
	private int x;
	private int y;
	private static int width;
	private static int height;
	private int type;
	
	public Location(int x, int y, int type) {
		this.setX(x);
		this.setY(y);
		this.setType(type);
	}
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
	
	public static int getWidth() {
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
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
