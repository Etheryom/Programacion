package BarajaMVCv2;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCarta extends JFrame {
	
	public static void main(String[] args) {
		
		Vista vista = new Vista();
		vista.arrancar(vista);
	    
	    Controlador controlador  = new Controlador(vista);

	}

}
