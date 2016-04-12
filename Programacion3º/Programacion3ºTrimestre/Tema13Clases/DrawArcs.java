package Tema13Clases;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawArcs extends JPanel {
	
	public DrawArcs(){
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		int x=getWidth();
		int y=getHeight();
		g.fillArc(0, 0, x,y, 0,30);
		g.fillArc(0, 0, x,y, 90,30);
		g.fillArc(0, 0, x,y, 180,30);
		g.fillArc(0, 0, x,y, 270,30);
	} 
	

}
