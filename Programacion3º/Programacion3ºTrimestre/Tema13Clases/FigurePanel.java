package Tema13Clases;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FigurePanel extends JPanel{
	
	public final static int LINE = 1;
	public final static int RECTANGLE = 2;
	public final static int ROUND_RECTANGLE = 3;
	public final static int OVAL = 4;
	
	private int type;
	private boolean filled;
	
	public FigurePanel(){
		
	}
	
	public FigurePanel(int type){
		this.type = type;
	}
	
	public FigurePanel(int type, boolean filled){
		this.type = type;
		this.filled = filled;	
	}
	
	protected void paintComponent(Graphics g) {
		
		switch(type){
			case 1:
				g.drawLine(0, 0, 50, 50);
			break;
			
			case 2:
				if(!filled){
					
				}
		}
		
	}

}
