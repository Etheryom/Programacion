package tema12Clases;
import java.awt.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyComponents extends JFrame{
	
	public MyComponents(){
		
	//-----<<>>PANEL 1<<>>------
		
	//Creo el panel  y los tres botones
	JPanel arriba = new JPanel();
	arriba.setLayout(new FlowLayout(0));
	JButton left = new JButton("Left");
	JButton center = new JButton("Center");
	JButton right = new JButton("Right");
	
	//AÃ±ado los botones al JPanel
	arriba.add(left);
	arriba.add(center);
	arriba.add(right);
	
	//Doy color al boton center
	center.setForeground(new Color(0,255,0));
	
	//Creo el border con color y titulo al Jpanel y al boton left
	arriba.setBorder(new LineBorder(new Color(102,255,255), 3));
	arriba.setBorder(new TitledBorder("Three Buttons"));

	//cursor cruz al JPanel "arriba"
	arriba.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	
	
	
	//-----<<>>PANEL 2<<>>------
	
	//Creo el panel de abajo con un gestor GridLayout para que tome todo el ancho de la columna y los dos JLabel
	JPanel abajo = new JPanel();
	abajo.setLayout(new GridLayout(1,2,2,0));
	JLabel red = new JLabel("Red");
	JLabel orange = new JLabel("Orange");
	
	//Agrego los JLabel al JPanel
	abajo.add(red);
	abajo.add(orange);
	
	//Cambio las fuentes y color de los JLabels
	red.setForeground(new Color(255,0,0));
	orange.setForeground(new Color(255,128,0));
	
	red.setFont(new Font("SansSerif ", Font.BOLD, 18));
	orange.setFont(new Font("SansSerif ", Font.BOLD, 18));
	
	//Asigno los bordes a los JLABELS
	red.setBorder(new LineBorder(new Color(0,0,0),2));
	orange.setBorder(new LineBorder(new Color(0,0,0),2));
	
	//Asigno Borde y color al JPanel
	abajo.setBorder(new LineBorder(new Color(102,255,255), 3));
	abajo.setBorder(new TitledBorder("Two Labels"));
	
	
	
	//-----<<>>FRAME<<>>------
	
	//Añado los dos JPanel al frame
	add(arriba,BorderLayout.NORTH);
	add(abajo,BorderLayout.CENTER);
	}
}
