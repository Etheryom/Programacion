package tema12Clases;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;

public class MyGridLayout extends JFrame {

	public MyGridLayout(){
		//Filas-columnas-separancion horizontal-separacion vertical
		setLayout(new GridLayout(3,2,10,10));
		
		add(new JLabel("Su nombre"));
		add(new JTextField(16));
		add(new JLabel("Su edad"));
		add(new JTextField(2));
		add(new JLabel("Sus Apellidos"));
		add(new JTextField(16));
	}
}
