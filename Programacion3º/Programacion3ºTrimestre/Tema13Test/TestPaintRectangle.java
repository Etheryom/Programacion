package Tema13Test;

import javax.swing.JFrame;

import Tema13Clases.PaintRectangle;

public class TestPaintRectangle extends JFrame {
	
	public TestPaintRectangle() {
		    add(new PaintRectangle());
		}

	public static void main(String[] args) {
		
	    TestPaintRectangle frame = new TestPaintRectangle();
	    frame.setTitle("TestPaintComponent");
	    frame.setSize(400, 200);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);  

	}

}
