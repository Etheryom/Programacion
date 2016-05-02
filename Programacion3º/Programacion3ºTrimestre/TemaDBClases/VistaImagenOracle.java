package TemaDBClases;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VistaImagenOracle extends JPanel {
	
	private ImageIcon ico;
	private Image imagen;
	
	public VistaImagenOracle(){
		
	ico = new ImageIcon("images/oracle.png");
	imagen = ico.getImage();
	setOpaque(false);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imagen, (getWidth()/2)-175, (getHeight()/2)-150, 350, 300,this);
	}
}
