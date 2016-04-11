package Tema13Test;

import javax.swing.JFrame;

import AhorcadoGraficoSinHerencia.TestAhorcadograficoSinHerencia;
import Tema13Clases.DrawArcs;

public class TestDrawArcs extends JFrame {

		public TestDrawArcs(){
			add(new DrawArcs());
		}
	public static void main(String[] args) {
		
		TestDrawArcs frame = new TestDrawArcs();
	    frame.setTitle("Ventilador");
	    frame.setSize(400,400);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 
	}

}
