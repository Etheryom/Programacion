package AhorcadoGraficoSinHerencia;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VictoriaDerrota extends JPanel {
	
	private boolean resultado;
	private ImageIcon iconImagen;
	private Image imagen;
	private JLabel marco;
	
	public VictoriaDerrota(Boolean resultado){
		this.resultado = resultado;
		
		if(resultado){
			iconImagen = new ImageIcon("images/victoria.gif");
			marco = new JLabel(iconImagen);
			imagen = iconImagen.getImage();
		}
		else{
			iconImagen = new ImageIcon("images/derrota.gif");
			marco = new JLabel(iconImagen);
			imagen = iconImagen.getImage();
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int x=getWidth();
		int y=getHeight();
		//Comienza la imagen en el punto 0,0 y llega hasta el getWidth y getHeight()
		g.drawImage(imagen, 0, 0,x,y, this );
	
	}
	
	

}
