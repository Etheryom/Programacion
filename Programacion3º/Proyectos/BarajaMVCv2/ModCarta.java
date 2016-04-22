package BarajaMVCv2;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ModCarta extends JPanel {
	
	private ImageIcon icono_Carta;
	private JButton boton_Carta;
	private Image imagen_Carta;
	private String palo;
	private int carta;
	
	public ModCarta(String palo, int carta){
		
		this.palo = palo;
		this.carta = carta;
		
		icono_Carta = new ImageIcon("baraja/"+palo+"/"+carta+".jpg");
		
		boton_Carta = new JButton(icono_Carta);
		
		imagen_Carta = icono_Carta.getImage();
		
		setOpaque(false);
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=getWidth();
		int y=getHeight();

		g.drawImage(imagen_Carta, 0, 0,100,160, this );
	}
}
