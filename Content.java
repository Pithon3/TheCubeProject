package thecubeproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Content extends JPanel implements ActionListener{

	private Camera camera;
	private Renderer renderer;
	private Graphics2D graphics;
	private Color graphicsColor;
	private ArrayList<ScreenPoint> screen;
	
	private int width = TheCubeProject.sWidth;
	private int height = TheCubeProject.sHeight;
	
	private final int FPS = 1000;
	private static final long serialVersionUID = 1L;
	
	public Content() {
		setBackground(Color.black);
		setFocusable(true);
		setDoubleBuffered(true);
		
		addKeyListener(new KeyInput());
		setFocusTraversalKeysEnabled(false);
		
		camera = new Camera(new Vector(0, 1, 0), new Point(0, -1, 0));
		renderer = new Renderer(camera);
		screen = new ArrayList<ScreenPoint>();
		
		Timer timer = new Timer(1000 / FPS, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		graphics = (Graphics2D) g;
		setColor(Color.white);
		
		//DRAW POINTS
		screen = renderer.getScreen();
		for (int i = 0; i < screen.size(); i++) {
			drawScreenPoint(screen.get(i));
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tempW = (int) getSize().getWidth();
		int tempH = (int) getSize().getHeight();
		
		//Fix startup bug, make sure window is displayed before changing height
		if (tempW != 0) {
			width = tempW;
		}
		if (tempH != 0) {
			height = tempH;
		}
		
		camera.update();
		renderer.update(width, height);
		
		repaint();
	}
	
	private void setColor(Color c) {
		graphics.setColor(c);
		graphicsColor = c;
	}
	
	private void drawScreenPoint(ScreenPoint p) {
		if (!p.getColor().equals(graphicsColor)) {
			setColor(p.getColor());
		}
		
		graphics.drawLine(p.getX() + width/2, -p.getY() + height/2, p.getX() + width/2, -p.getY() + height/2);
		
	}
	
	//START KEYINPUT CLASS
	private class KeyInput extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			switch (key) {
			case KeyEvent.VK_SPACE:
				camera.setUp(true);
				break;
			case KeyEvent.VK_SHIFT:
				camera.setDown(true);
				break;
			case KeyEvent.VK_A:
				camera.setLeft(true);
				break;
			case KeyEvent.VK_D:
				camera.setRight(true);
				break;
			case KeyEvent.VK_W:
				camera.setForward(true);
				break;
			case KeyEvent.VK_S:
				camera.setBackward(true);
				break;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e){
			int key = e.getKeyCode();
			
			switch (key) {
			case KeyEvent.VK_SPACE:
				camera.setUp(false);
				break;
			case KeyEvent.VK_SHIFT:
				camera.setDown(false);
				break;
			case KeyEvent.VK_A:
				camera.setLeft(false);
				break;
			case KeyEvent.VK_D:
				camera.setRight(false);
				break;
			case KeyEvent.VK_W:
				camera.setForward(false);
				break;
			case KeyEvent.VK_S:
				camera.setBackward(false);
				break;
			}
		}
		
	}
	
}
