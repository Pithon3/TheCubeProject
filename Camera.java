package thecubeproject;

public class Camera {

	private Vector direction;
	private Point location;
	
	private boolean UP, DOWN, LEFT, RIGHT, FORWARD, BACKWARD;
	private final double SPEED = 0.3;
	
	public Camera(Vector v, Point p) {
		direction = v;
		location = p;
	}
	
	public void update() {
		if (UP) {
			location.changeZBy(SPEED);
		}
		if (DOWN) {
			location.changeZBy(-SPEED);
		}
		if (LEFT) {
			location.changeXBy(-SPEED);
		}
		if (RIGHT) {
			location.changeXBy(SPEED);
		}
		if (FORWARD) {
			location.changeYBy(SPEED);
		}
		if (BACKWARD) {
			location.changeYBy(-SPEED);
		}
	}
	
	public void setUp(boolean c) {
		UP = c;
	}
	
	public void setDown(boolean c) {
		DOWN = c;
	}
	
	public void setLeft(boolean c) {
		LEFT = c;
	}
	
	public void setRight(boolean c) {
		RIGHT = c;
	}
	
	public void setForward(boolean c) {
		FORWARD = c;
	}
	
	public void setBackward(boolean c) {
		BACKWARD = c;
	}
	
	public Point getLocation() { return location; }

}
