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
		
		int y = getHeight();
		int x = getWidth();
		System.out.println("La anchura actual del Panel es\n"+"Anchura: "+y+"\nAltura: "+x);
		
		switch(type){
			case LINE:
				g.drawLine(0,0,x,y);
				g.drawLine(x,0,0,y);
			break;
			
			case RECTANGLE:
				if(!filled)
					g.drawRect(10,10,x-20,y-20);
				else
					g.fillRect(10,10,x-20,y-20);
			break;
				
			case ROUND_RECTANGLE:
				if(!filled)
					g.drawRoundRect(10, 10, x-20, y-20, 75, 75);
				else
					g.fillRoundRect(10, 10, x-20, y-20, 75, 75);
			break;
			
			case OVAL: 
				if(!filled)
					//Lo coloco en la mitad dividiendolo entre 4 
					g.drawOval(x/4,y/4,x/2,y/2);
				else
					g.fillOval(x/4,y/4,x/2,y/2);
		}
		
	}
	
	public String getType(){
		String getType="";
		switch(type){
			case LINE: getType = "This figure is a line";
			break;
			
			case RECTANGLE: getType = "This figure is a rectangle";
			break;
			
			case ROUND_RECTANGLE: getType = "This figure is a round rectangle";
			break;
			
			case OVAL: getType = "This figure is a oval";
			break;
				
		}
		return getType;
	}
	public void setType(int type){
		this.type = type;
		repaint();
	}
	
	public boolean getFilled(){
		if(filled)
			return true;
		else
			return false;
	}
	
	public void setFilled(boolean filled){
		this.filled = filled;
		repaint();
	}

}
