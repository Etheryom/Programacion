package Tema13Clases;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DisplayImagen extends JPanel {
	
	private ImageIcon iconFlag;
	private JButton spain;
	private Image flag;
	
	public DisplayImagen(){
		
		//Creo icono, lo introduzco en el boton e instancio la imagen con el icono
		iconFlag = new ImageIcon("images/flagspain.png");
		spain = new JButton(iconFlag);
		flag = iconFlag.getImage();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=getWidth();
		int y=getHeight();
		//Comienza la imagen en el punto 0,0 y llega hasta el getWidth y getHeight()
		g.drawImage(flag, 0, 0,x,y, this );
		
	}
}
