package BarajaMVCv2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VistaCarta extends JPanel {
	private ImageIcon imageIcon;
	private Image imagen;
	
	public VistaCarta(ImageIcon imageIcon){
		this.imageIcon = imageIcon;
		imagen = imageIcon.getImage();	
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imagen, 0, 0,100,160, this);
	}

}
