package tema12Clases;
import javax.swing.*;

public class FlowLayout extends JFrame {
	
	public FlowLayout(){

		//Lo coloco con el import, ya que arriba me lo toma como obsoleto.
		setLayout(new java.awt.FlowLayout(0, 10, 20));
		
	    add(new JLabel("Su nombre"));
	    add(new JTextField(16));
	    add(new JLabel("Edad"));
	    add(new JTextField(2));
	    add(new JLabel("Apellidos"));
	    add(new JTextField(16));
	}
}
