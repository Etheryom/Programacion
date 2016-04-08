package Tema13Test;

import javax.swing.JFrame;

import Tema13Clases.FigurePanel;


public class TestFigurePanel extends JFrame {

	public TestFigurePanel() {
		add(new FigurePanel(1));
	}
		
		
	public static void main(String[] args) {
	    TestFigurePanel frame = new TestFigurePanel();
	    frame.setTitle("TestPaintComponent");
	    frame.setSize(400, 200);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);  
	}

}
