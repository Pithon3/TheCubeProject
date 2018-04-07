package thecubeproject;

import java.awt.Color;

public class ScreenPoint {
	
	int X, Y;
	Color color;
	
	public ScreenPoint(int x, int y, Color c) {
		X = x;
		Y = y;
		color = c;
	}
	
	public int getX() { return X; }
	
	public int getY() { return Y; }
	
	public Color getColor() { return color; }
	
}
