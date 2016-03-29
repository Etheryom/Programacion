package tema12Clases;
import javax.swing.*;

public class FlowLayout extends JFrame {
	
	public FlowLayout(){

		//Coloco el FlowLayout con la ruta completa, ya que arriba me lo toma como obsoleto.
		// 1ºParametro: <<< 0 = Izquierda 	 1 = centro 	 2 = derecha >>>>
		// 2ºParametro: Distancia horizontal entre elementos
		// 3ºParametro: Distancia vertical entre elementos
		setLayout(new java.awt.FlowLayout(0, 10, 15));
		
	    add(new JLabel("Su nombre"));
	    add(new JTextField(16));
	    add(new JLabel("Edad"));
	    add(new JTextField(2));
	    add(new JLabel("Apellidos"));
	    add(new JTextField(16));
	}
}
