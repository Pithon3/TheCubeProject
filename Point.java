package thecubeproject;

import java.awt.Color;
import java.util.ArrayList;

public class Point implements Obj {
	
	private static ArrayList<Plane> screenBounds;
	private static Camera camera;
	
	double X, Y, Z;
	Color color;
	
	public static final Point ZERO = new Point(0,0,0);
	
	public Point(double x, double y, double z, Color c) {
		X = x;
		Y = y;
		Z = z;
		color = c;
	}
	
	public Point(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
		color = new Color(255, 0, 255);
	}

	@Override
	public ArrayList<ScreenPoint> getScreenPoints(double viewPosition) {
		ArrayList<ScreenPoint> points = new ArrayList<ScreenPoint>();
		if (true) {//isInBounds()) {
			points.add(getScreenPoint(viewPosition));
		}
		return points;
	}
	
	private ScreenPoint getScreenPoint(double viewPosition) {
		//Tranform point relative to the camera
		double tempX = X - camera.getLocation().getX();
		double tempY = Y - camera.getLocation().getY();
		double tempZ = Z - camera.getLocation().getZ();
		
		
		double sX = (tempX * viewPosition) / (tempY + viewPosition);
		double sY = (tempZ * viewPosition) / (tempY + viewPosition);
	
		return new ScreenPoint((int) sX, (int) sY, color);
	}
	
	private boolean isInBounds() {
		boolean temp = true;
		
		for (int i = 0; i < screenBounds.size(); i++) {
			if (!screenBounds.get(i).contains(this)) {
				temp = false;
			}
		}
		
		return temp;
	}
	
	public double getX() { return X; }
	
	public double getY() { return Y; }
	
	public double getZ() { return Z; }
	
	public Color getColor() { return color; }
	
	public int getIntX() { return (int) X; }
	
	public int getIntY() { return (int) Y; }
	
	public int getIntZ() { return (int) Z; }
	
	public void setX(double x) {
		X = x;
	}
	
	public void setY(double y) {
		Y = y;
	}
	
	public void setZ(double z) {
		Z = z;
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void changeXBy(double delta) {
		setX(X += delta);
	}
	
	public void changeYBy(double delta) {
		setY(Y += delta);
	}
	
	public void changeZBy(double delta) {
		setZ(Z += delta);
	}
	
	public double distance(Point p) {
		return Math.sqrt( Math.pow(X - p.getX(), 2) + Math.pow(Y - p.getY(), 2) + Math.pow(Z - p.getZ(), 2));
	}
	
	public static void setScreenBounds(ArrayList<Plane> sb) {
		screenBounds = sb;
	}
	
	public static void setCamera(Camera cam) {
		camera = cam;
	}
	
}
