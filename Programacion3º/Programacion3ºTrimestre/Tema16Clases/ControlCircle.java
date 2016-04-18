package Tema16Clases;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ControlCircle extends JPanel {
	
	private int radio;
	
	public ControlCircle(){
		this(1);
	}
	
	public ControlCircle(int radio){
		this.radio = radio;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = getWidth();
		int y = getHeight();
		g.drawOval(x/2, y/2, radio, radio);
	}
	
	public void setRadio(int radio){
		this.radio = radio;
		repaint();	
	}
	public int getRadio(){
		return radio;
	}

}
