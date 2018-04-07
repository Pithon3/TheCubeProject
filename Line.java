package thecubeproject;

import java.awt.Color;
import java.util.ArrayList;

public class Line implements Obj {

	Point point1, point2;
	Color color;
	
	public Line(double x1, double y1, double z1, double x2, double y2, double z2, Color c) {
		point1 = new Point(x1, y1, z1, c);
		point2 = new Point(x2, y2, z2, c);
		color = c;
	}
	
	public Line(Point p1, Point p2, Color c) {
		point1 = p1;
		point2 = p2;
		color = c;
	}

	@Override
	public ArrayList<ScreenPoint> getScreenPoints(double viewPosition) {
		return null;
	}
	
}
