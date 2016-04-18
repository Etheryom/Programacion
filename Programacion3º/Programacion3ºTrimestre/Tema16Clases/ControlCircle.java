package Tema16Clases;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ControlCircle extends JPanel {
	
	private double radio;

	
	public ControlCircle(){
		this(1.0);
	}
	
	public ControlCircle(double radio){
		this.radio = radio;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = getWidth();
		int y = getHeight();
		g.drawOval((int)(x/2-radio/2), (int)(y/2-radio/2),(int) radio,(int) radio);
	}
	
	public void setRadio(double radio){
		this.radio = radio;
		repaint();	
	}
	
	public void setIncrementoRadio(){
		this.radio += 1;
		repaint();	
	}
	
	public void setIncrementoRadio(int intervalo){
		this.radio += intervalo;
		repaint();	
	}
	
	public void setDecrementoRadio(){
		this.radio -= 1;
		repaint();	
	}
	
	public void setDecrementoRadio(int intervalo){
		this.radio -= intervalo;
		repaint();	
	}
	
	public double getRadio(){
		return radio;
	}

}
