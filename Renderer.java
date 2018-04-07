package thecubeproject;

import java.awt.Color;
import java.util.ArrayList;

public class Renderer {
	
	private ArrayList<Plane> screenBounds;
	private ArrayList<Obj> objects;
	private ArrayList<ScreenPoint> screen;
	
	private double renderDistance = 200;
	private double viewPosition = 200;
	private double screenWidth = TheCubeProject.sWidth;
	private double screenHeight = TheCubeProject.sHeight;
	
	public Renderer(Camera cam) {
		screen = new ArrayList<ScreenPoint>();
		objects = new ArrayList<Obj>();
		screenBounds = new ArrayList<Plane>();
		
		setScreenBounds();
		Point.setScreenBounds(screenBounds);
		Point.setCamera(cam);
		
		objects.add(new Point(-50, 0, 0, Color.white));
		objects.add(new Point(50, 0, 0, Color.white));
		objects.add(new Point(-50, 0, 100, Color.white));
		objects.add(new Point(50, 0, 100, Color.white));
		objects.add(new Point(-50, 100, 0, Color.white));
		objects.add(new Point(50, 100, 0, Color.white));
		objects.add(new Point(-50, 100, 100, Color.white));
		objects.add(new Point(50, 100, 100, Color.white));
		
	}
	
	public void update(int width, int height) {
		screen.clear();
		if (screenWidth != width || screenHeight != height) {
			screenWidth = width;
			screenHeight = height;
			setScreenBounds();
		}
		
		for (int i = 0; i < objects.size(); i++) {
			screen.addAll(objects.get(i).getScreenPoints(viewPosition));
		}
	}
	
	public ArrayList<ScreenPoint> getScreen() {
		return screen;
	}
	
	private void setScreenBounds() {	//Rendering boundaries
		System.out.println(screenWidth);
		screenBounds.clear();
		screenBounds.add(new Plane( new Vector(0, -0.5 * screenWidth * screenHeight, viewPosition * screenWidth), new Point(0,-viewPosition,0) ));		//Upper  Bounding Plane
		screenBounds.add(new Plane( new Vector(-viewPosition * screenHeight, -0.5 * screenWidth * screenHeight, 0), new Point(0,-viewPosition,0) ));	//Left   Bounding Plane
		screenBounds.add(new Plane( new Vector(0, -0.5 * screenWidth * screenHeight, -viewPosition * screenWidth), new Point(0,-viewPosition,0) ));		//Bottom Bounding Plane
		screenBounds.add(new Plane( new Vector(viewPosition * screenHeight, -0.5 * screenWidth * screenHeight, 0), new Point(0,-viewPosition,0) ));		//Right  Bounding Plane
		screenBounds.add(new Plane( new Vector(0,-1,0), Point.ZERO ));																					//Front  Bounding Plane
		screenBounds.add(new Plane( Vector.J, new Point(0,renderDistance,0) ));																			//Rear   Bounding Plane
	}
	
}
