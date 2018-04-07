package thecubeproject;

import javax.swing.JFrame;

public class TheCubeProject extends JFrame {

	Content content; 
	
	public static final int sWidth = 640;
	public static final int sHeight = 480;
	public static final String VERSION = "2.0.1";
	
	private static final long serialVersionUID = 1L;

	public TheCubeProject() {
		content = new Content();
		add(content);
		
		//Initialize the Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(sWidth, sHeight + 22);
		setLocationRelativeTo(null);
		setTitle("The Cube Project " + VERSION);
		setResizable(true);
		setVisible(true);
		
	}
	
	public static void main(String args[]) {
		new TheCubeProject();
	}
	
}
