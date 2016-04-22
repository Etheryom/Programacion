package BarajaMVCv2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class VistaCarta extends JPanel {
	
	private Image imagen;
	
	public VistaCarta(Image image){
		this.imagen = imagen;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=getWidth();
		int y=getHeight();

		g.drawImage(imagen, 0, 0,100,160, this );
	}

}
