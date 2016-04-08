package Tema13Test;

import javax.swing.JFrame;

import Tema13Clases.FigurePanel;


public class TestFigurePanel extends JFrame {

	public TestFigurePanel() {
		FigurePanel panel1 = new FigurePanel(FigurePanel.OVAL,true);
		System.out.println(panel1.getType());
		//panel1.setType(2);
		//panel1.setFilled(false);
		add(panel1);
		
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
