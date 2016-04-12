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
		iconFlag = new ImageIcon("images/flagspain.png");
		spain = new JButton(iconFlag);
		flag = iconFlag.getImage();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=getWidth();
		int y=getHeight();
		g.drawImage(flag, 0, 0,x,y, this );
		
	}
}
