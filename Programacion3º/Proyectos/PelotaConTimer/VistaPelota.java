package PelotaConTimer;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class VistaPelota extends JPanel {
	
	private ModPelota pelota;
	
	public VistaPelota(ModPelota pelota){
		
		this.pelota=pelota;
		setOpaque(false);
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
		
		//pelota
		
		g.fillOval(pelota.getX(), pelota.getY(), pelota.getRadio(), pelota.getRadio());
	}
	
	public ModPelota getModPelota(){
		return pelota;
	}
}