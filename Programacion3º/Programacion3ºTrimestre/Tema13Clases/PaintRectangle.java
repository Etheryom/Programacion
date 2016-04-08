package Tema13Clases;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintRectangle extends JPanel {
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    g.drawRect(100, 25, 200, 100);
	    g.drawLine(100, 25,300, 125);	 
	    }

}
