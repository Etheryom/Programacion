//////////////////////////////////////////////////////////////////////////////////
//Esta clase dibujará cada una de las imagenes que se presenten  en el proyecto //
//////////////////////////////////////////////////////////////////////////////////
package Universidad.Vista;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DibujarImagenes extends JPanel  {
	
	private ImageIcon icon;
	private Image imagen;
	private int seleccionada;
	private JLabel buton;
	
	public static final int IMAGEN_LOGIN = 1;
	public static final int IMAGEN_UNIVERSIDAD = 2;

	public DibujarImagenes(int seleccionada){

		this.seleccionada = seleccionada;
		
		switch(seleccionada){
		
			case IMAGEN_LOGIN: 
				icon = new ImageIcon("universidad/login.png");
				imagen = icon.getImage();
				buton = new JLabel("                                                        ");
				add(buton);
			break;
			
			case IMAGEN_UNIVERSIDAD: 
				icon = new ImageIcon("universidad/universidad.png");
				imagen = icon.getImage();
			break;
		}
		setOpaque(false);
			
	}
	
	protected void paintComponent(Graphics g){
		
		switch(seleccionada){
		
			case IMAGEN_LOGIN: g.drawImage(imagen, 10, (int)(getHeight()*0.07), 150,150, this);break;
			
			case IMAGEN_UNIVERSIDAD: g.drawImage(imagen,(int)(getWidth()*0.15), getHeight()/8, (int)(getWidth()*0.8),(int)(getHeight()*0.8), this);break;
		}
	}
}
