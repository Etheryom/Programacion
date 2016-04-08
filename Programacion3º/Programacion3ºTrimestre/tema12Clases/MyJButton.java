package tema12Clases;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyJButton extends JFrame{
	
	public MyJButton(){
		
		JPanel banderas = new JPanel( new GridLayout(1,4,1,1));
		
		//JBUTTONs con los parametros (texto e instancia de imagen)
		
		JButton espania = new JButton("ESPAÑA",new ImageIcon("images/flagspain.png"));
		JButton francia = new JButton("FRANCIA",new ImageIcon("images/francia.jpg"));
		JButton canada = new JButton("CANADA",new ImageIcon("images/canada.gif"));
		JButton eeuu = new JButton("EEUU",new ImageIcon("images/EstadosUnidos.png"));
		
		//Insetamos al JPanel
		banderas.add(espania);
		banderas.add(francia);
		banderas.add(canada);
		banderas.add(eeuu);
		
		//Movemos los textos para colocarlos bajo las banderas
		espania.setHorizontalTextPosition(SwingConstants.CENTER);
		espania.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		francia.setHorizontalTextPosition(SwingConstants.CENTER);
		francia.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		canada.setHorizontalTextPosition(SwingConstants.CENTER);
		canada.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		eeuu.setHorizontalTextPosition(SwingConstants.CENTER);
		eeuu.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		//Pressed icon
		espania.setPressedIcon(new ImageIcon("images/flagspain2.png"));
		francia.setPressedIcon(new ImageIcon("images/francia2.jpg"));
		canada.setPressedIcon(new ImageIcon("images/canada2.gif"));
		eeuu.setPressedIcon(new ImageIcon("images/eeuu2.gif"));
		
		//Rollover icon
		espania.setRolloverIcon( new ImageIcon("images/flagspain3.png"));
		francia.setRolloverIcon( new ImageIcon("images/francia3.jpg"));
		canada.setRolloverIcon( new ImageIcon("images/canada3.gif"));
		eeuu.setRolloverIcon( new ImageIcon("images/eeuu3.gif"));
		
		
		//Añadimos JPanel al JFrame
		add(banderas);
	}
	

}
