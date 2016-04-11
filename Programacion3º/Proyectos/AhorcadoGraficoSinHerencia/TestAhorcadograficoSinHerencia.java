package AhorcadoGraficoSinHerencia;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class TestAhorcadograficoSinHerencia extends JFrame {
	
	public TestAhorcadograficoSinHerencia(){
		
		add(new AhorcadoGrafico(6));
		
		/*JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setSize(800, 600);
		int inserted=0;
		while(inserted!=8){
		inserted=Integer.parseInt(JOptionPane.showInputDialog(null,panel,"Information"));
		panel.add(new AhorcadoGrafico(inserted));
		}
		add(panel);
		*/
			
	}


	public static void main(String[] args) {
		
		TestAhorcadograficoSinHerencia frame = new TestAhorcadograficoSinHerencia();
	    frame.setTitle("Ahorcado");
	    frame.setSize(800,600);
	    frame.setLocationRelativeTo(null); // Center the frame   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true); 

	}

}
