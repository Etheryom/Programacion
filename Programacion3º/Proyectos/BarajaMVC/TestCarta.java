package BarajaMVC;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCarta extends JFrame {
	
	public static void main(String[] args) {
		
		
		Vista vista = new Vista();
		vista.setSize(1200,600);
		vista.setTitle("Carta");
		vista.setVisible(true);
	    vista.setLocationRelativeTo(null);
	    vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Controlador controlador  = new Controlador(vista);

	}

}
