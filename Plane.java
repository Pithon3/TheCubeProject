package thecubeproject;

public class Plane {

	private Vector normalVector;
	private Point point;
	
	public Plane(Vector v, Point p) {
		normalVector = v;
		point = p;
	}
	
	public boolean contains(Point p) {
		boolean temp = false;
		
		//System.out.println("P: (" + normalVector.getX() + ", " + normalVector.getY() + ", " + normalVector.getZ() + ")       Angle: " + normalVector.getAngle(new Vector(point, p)));
		
		double angle = normalVector.getAngle(new Vector(point, p));
		if (angle >= Math.PI/2 || angle == 0) {
			temp = true;
		}
		
		return temp;
	}
	
	public Point getPoint() { return point; }
	
	public Point getNormalVector() { return normalVector; }
	
	public void setPoint(Point p) {
		point = p;
	}
	
	public void setNormalVector(Vector v) {
		normalVector = v;
	}
	
}
