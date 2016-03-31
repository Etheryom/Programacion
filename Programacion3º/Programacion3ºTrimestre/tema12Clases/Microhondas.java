package tema12Clases;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Microhondas extends JFrame {

	
	public Microhondas(){
		
		//Añado el boton que representa la puerta al frame
		add(new JButton("ESTO ES LA PUERTA"));
		
		//Creo un panel y llamo al metodo panelNumero() para crearme el gridLayout con los botones
		JPanel numeros = panelNumerico();
		
		
		/*1-Creo panel  elem como un BorderLayout
		 *2-Añado el textfield al norte y el panel numero al este, ya que si lo coloco al sur crea un vacio intermedio
		 *3-Añado panel elem al Frame
		 */
		JPanel elem = new JPanel(new BorderLayout());
	    elem.add(new JTextField("ESTO ES EL CONTADOR"),BorderLayout.NORTH);
	    elem.add(numeros,BorderLayout.EAST);
	    add(elem, BorderLayout.EAST);
			
	}
	
	
	//Creo el panel, lo relleno con el bucle y lo devuelvo
	public JPanel panelNumerico(){
		JPanel numeros = new JPanel (new GridLayout(4,3));
		
		for(int i =1;i<=10;i++){
			
			if(i<10)
				numeros.add(new JButton(""+i));	
			else{
				numeros.add(new JButton("0"));
				numeros.add(new JButton("Start"));
				numeros.add(new JButton("Stop"));
			}
		}
		return numeros;
	}
	
}
