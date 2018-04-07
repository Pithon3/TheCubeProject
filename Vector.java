package thecubeproject;

public class Vector extends Point {

	private double magnitude, theta, phi;

	public static final Vector I = new Vector(1,0,0);
	public static final Vector J = new Vector(0,1,0);
	public static final Vector K = new Vector(0,0,1);
	
	public Vector(double x, double y, double z) {
		super(x, y, z);
		calculateSphericalComponents();
	}
	
	public Vector(Point p1, Point p2) {
		super(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
		calculateSphericalComponents();
	}
	
	public double getAngle(Vector v) {
		double angle = 0;
		
		if (magnitude * v.getMagnitude() != 0) {
			angle =  Math.acos( dotProduct(v) / (magnitude * v.getMagnitude()) );
		}
		
		return angle;
	}
	
	public double dotProduct(Vector v) {
		return getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ();
	}
	
	private void calculateRectangularComponents() {
		setX( magnitude * Math.cos(phi) * Math.sin(theta) );
		setY( magnitude * Math.cos(phi) * Math.cos(theta) );
		setZ( magnitude * Math.sin(phi) );
	}
	
	private void calculateSphericalComponents() {
		calculateMagnitude();
		theta = Math.atan( getX() / getY() );
		phi = Math.asin( getZ() / magnitude );
	}
	
	private void calculateMagnitude() {
		magnitude = distance(new Point(0,0,0));
	}
	
	public double getTheta() { return theta; }

	public double getPhi() { return phi; }
	
	public double getMagnitude() { return magnitude; }
	
	public void setTheta(double angle) { 
		theta = angle;
		calculateRectangularComponents();
	}
	
	public void setPhi(double angle) { 
		phi = angle;
		calculateRectangularComponents();
	}

	public void setMagnitude(double r) {
		magnitude = r;
		calculateRectangularComponents();
	}
	
	public void changeThetaBy(double delta) {
		theta += delta;
		calculateRectangularComponents();
	}

	public void changePhiBy(double delta) {
		phi += delta;
		calculateRectangularComponents();
	}
	
	public void setX(double x) {
		super.setX(x);
		calculateSphericalComponents();
	}
	
	public void setY(double y) {
		super.setY(y);
		calculateSphericalComponents();
	}
	
	public void setZ(double z) {
		super.setZ(z);
		calculateSphericalComponents();
	}
	
	public Vector add(Point p) {
		return new Vector(X + p.getX(), Y + p.getY(), Z + p.getZ());
	}
	
	public Vector scalarMult(double s) {
		return new Vector(s * X, s * Y, s * Z);
	}
}
