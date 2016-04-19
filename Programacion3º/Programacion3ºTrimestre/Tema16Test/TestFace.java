package Tema16Test;



import javax.swing.JFrame;

import Tema16Clases.Controlador;
import Tema16Clases.Vista;

public class TestFace {
	  public static void main(String[] args) {
		   Vista frame = new Vista();
		    
		    Controlador controler = new Controlador (frame);
		  
		    frame.setTitle("ControlCircle");
		    frame.setLocationRelativeTo(null); // Center the frame
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(600, 600);
		    frame.setVisible(true);
		  }
}
