package AhorcadoGraficoConHerencia;
import javax.swing.JFrame;

import Tema13Test.TestFigurePanel;

public class TestAhorcadoGrafico extends JFrame {
	
	public TestAhorcadoGrafico(){
		add(new PiernaIzquierda());
	}
	public static void main(String[] args) {
	    
		TestAhorcadoGrafico frame = new TestAhorcadoGrafico();
	    frame.setTitle("Ahorcado");
	    frame.setSize(800,600);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);  

	}

}
