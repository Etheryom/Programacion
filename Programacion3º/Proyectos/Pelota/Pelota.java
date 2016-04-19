package Pelota;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pelota extends JPanel {

	private int radio;
	private int velocidad;
	private int x;
	private int y;
	
	public Pelota(){
		this(2);
		
	}
	
	public Pelota(int radio){
		this.radio = radio;
		x = 100;
		y = 200;
		velocidad = 10;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
		
		//Centro del campo -linea y circulo-
		g.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
		g.drawOval((getWidth()/2)-50, (getHeight()/2)-50, 100, 100);
		
		//Area izquierda
		g.drawRect(0, (getHeight()/2)-200, 100, (getHeight()/2));
		
		//Area Derecha
		g.drawRect(getWidth()-100, (getHeight()/2)-200, getWidth(), (getHeight()/2));
		
		//Pelota
		g.fillOval(x, y, radio, radio);
		
		
	}
	
	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}
	
	public void moverDerecha(boolean derecha){
		
		//Si va hacia la derecha
		if(derecha){
			//Si va hacia la derecha y no supera el limite derecho
			if(x<getWidth()){
				x+=velocidad;
				repaint();
			}
			//Si va hacia la derecha  y supera el limite derecho
			else if(x>=getWidth()){
				x=0-radio;
				repaint();
			}
		}
		
		//Si va hacia la izquierda
		else{
			
			//Si va hacia la izquierda y  no supera el limite izquierdo
			if(x>(0-radio)){
				x-=velocidad;
				repaint();
			}
			
			//Si va hacia a izquierda y supera el limite izquierdo
			else if(x<=(0-radio)){
				x=getWidth();
				repaint();
			}	
		}
	}
	public void moverAbajo(boolean abajo){
		
		//Si va hacia abajo
		if(abajo){
			
			//Si va hacia abajo y no supera el limite inferior
			if(y<getHeight()){
				y+=velocidad;
				repaint();
			}
			//Si va hacia abajo y supera el limite inferior
			else if(y>=getHeight()){
				y=0-radio;
				repaint();
			}
		}
		
		//Si va hacia arriba
		else{
			
			//Si va hacia arriba y  no supera el limite superior
			if(y>(0-radio)){
				y-=velocidad;
				repaint();
			}
			
			//Si va hacia arriba y supera el limite superior
			else if(y<=(0-radio)){
				y=getHeight();
				repaint();
			}	
		}
		
	}
}
